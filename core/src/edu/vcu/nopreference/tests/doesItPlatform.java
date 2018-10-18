package edu.vcu.nopreference.tests;

import com.badlogic.gdx.utils.Logger;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class doesItPlatform {

    @Test
    public void doesItMove() {
        Render.testing = true;
        Platform tempPlat = new Platform();
        tempPlat.setPlatformSpeed(50);
        tempPlat.posX = 500;
        tempPlat.update();
        assertEquals(500 - tempPlat.getPlatformSpeed(), tempPlat.posX, 1.0);
    }

    @Test
    public void amIRandom() {
        Render.testing = true;
        Platform tempPlat = new Platform();
        double tempPos = tempPlat.posY;
        tempPlat = new Platform();
        assertNotEquals(tempPos, tempPlat.posY, 0.0001);
    }

    /* Scenario: Given that I am in game moving towards a platform, when I tap the screen, then I
    should move upwards and then fall towards a platform, and when it looks like I
    should fall to rest on a platform, then I should land on that platform.*/
    @Test
    public void canIStep() {
        Render.testing = true;
        objectManager tempOM = new objectManager(); // Dummy objectManager to run the game simulation

        Platform tempPlat = new Platform();
        tempPlat.posX = 500;
        tempPlat.posY = 100;
        tempOM.addObject(tempPlat);     // Add platform to object manager.

        Player tempPlayer = new Player();
        tempPlayer.posX = 450;          // Player is not quite above the platform, is slightly to the left.
        tempPlayer.posY = 215;          // By the time the player falls onto the platform, ya boi will be squarely on the platform.
        tempOM.addObject(tempPlayer);   // Add player to object manager.

        // Run the game for two ticks.
        tempOM.logicTick(); // The first tick adds the new objects to the object lists.
        tempOM.logicTick();
        tempOM.logicTick();

        assertEquals(100, tempOM.getObjectByIndex(0).posY, 1.0);    // Platform is indeed at height of 100.
        assertEquals(200, tempOM.getObjectByIndex(1).posY, 1.0);    // Ya boi tempPlayer is on the platform at height 200.
    }

    /* Scenario: Given that I am in game moving towards a platform, when I tap the screen, then I
    should move upwards and then fall towards a platform, and when it looks like I
    shouldn’t fall to rest on a platform, then I should fall back to the ground. */
    @Test
    public void canIMiss() {
        Render.testing = true;
        objectManager tempOM = new objectManager(); // Dummy objectManager to run the game simulation

        Platform tempPlat = new Platform();
        tempPlat.posX = 500;
        tempPlat.posY = 100;
        tempOM.addObject(tempPlat);     // Add platform to objectManager

        Player tempPlayer = new Player();
        tempPlayer.posX = 950;          // Player is currently 50 units overlapping at end of platform
        tempPlayer.posY = 215;          // By the time the player reaches the platform height, the platform has moved 100 units to the left and should not collide.
        tempOM.addObject(tempPlayer);   // Add player to objectManager

        // Run the game for five ticks
        tempOM.logicTick(); // The first tick adds newObjects to Objects and does not count.
        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();

        assertEquals(100, tempOM.getObjectByIndex(0).posY, 1.0);    // Platform is indeed at height of 100.
        assertNotEquals(200, tempOM.getObjectByIndex(1).posY, 1.0); // Ya boi tempPlayer is not the platform at height 200.
        assertEquals(65, tempOM.getObjectByIndex(1).posY, 1.0);     // Given that tempPlayer has been falling for 5 ticks, ya boi should be at 65 units in height.
    }

    /* Scenario: Given that I am in game and a platform is above me, when I tap the screen, then I
    should move upwards and will land on the platform */
    @Test
    public void canIJump() {
        Render.testing = true;
        objectManager tempOM = new objectManager();

        Platform tempPlat = new Platform();
        tempPlat.posX = 500;
        tempPlat.posY = 100;
        tempPlat.setPlatformSpeed(0);
        tempOM.addObject(tempPlat);

        Player tempPlayer = new Player();
        tempPlayer.posX = 500;
        tempPlayer.posY = 0;
        tempOM.addObject(tempPlayer);

        tempPlayer.update();
        tempPlayer.physics.Jump();
        assertTrue(tempPlayer.physics.velocityY > 0.1);//Jump successful

        int i = 0;
        while(1000 > i++){
            tempOM.logicTick();
        }
        assertEquals(tempPlayer.posY, tempPlat.posY+tempPlat.sprite.getHeight(), 1);

    }
}