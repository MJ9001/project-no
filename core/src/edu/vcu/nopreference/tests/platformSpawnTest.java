package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.inGameObjects.Platform;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class platformSpawnTest {

    // Given that I am on the ground, when a new platform spawns, it should be easily reachable.
    @Test
    public void groundSpawn() {
        Render.testing = true;
        objectManager tempOM = new objectManager();

        Player tempPlayer = new Player();
        tempPlayer.posX = 100;
        tempPlayer.posY = 0;    // Player on the ground.
        tempOM.addObject(tempPlayer);

        for (int i =0; i < 1000; i++) {
            Platform tempPlat = new Platform(tempPlayer);
            tempOM.addObject(tempPlat);
            tempOM.logicTick();
            assertTrue(tempPlat.posY < 500f); // A platform of height 500 is always reachable by the player.
        }
    }

    // Given that I am above the ground, when a new platform spawns, it should be higher than the if I were on the ground.
    @Test
    public void upInTheAir() {
        Render.testing = true;
        objectManager tempOM = new objectManager();

        Player tempPlayer = new Player();
        tempPlayer.posX = 100;
        tempPlayer.posY = 1000; // Player way above the ground.
        tempOM.addObject(tempPlayer);

        for (int i =0; i < 1000; i++) {
            Platform tempPlat = new Platform(tempPlayer);
            tempOM.addObject(tempPlat);
            tempOM.logicTick();
            tempPlayer.posY = 1000; // Keeps the player way above the ground.
            assertTrue(tempPlat.posY > 500f); // This means they are spawning higher than your normal level.
        }
    }

    //  Given that I am above the ground, when a new platform spawns it should be higher than if I were on the ground, and then if I fall from back to the ground, the next platform that spawns should be reachable by a jump from the ground.
    @Test
    public void fallFromGrace() {
        Render.testing = true;
        objectManager tempOM = new objectManager();

        Player tempPlayer = new Player();
        tempPlayer.posX = 100;
        tempPlayer.posY = 1000;  // Player way above the ground.
        tempOM.addObject(tempPlayer);

        Platform tempPlat = new Platform(tempPlayer);
        tempOM.addObject(tempPlat);
        tempOM.logicTick();
        assertTrue(tempPlat.posY > 500f); // This means they are spawning higher than your normal level.

        for (int i =0; i < 1000; i++) { // Player falling to the ground.
            tempOM.logicTick();
        }

        tempPlat = new Platform(tempPlayer);
        tempOM.addObject(tempPlat);
        tempOM.logicTick();
        assertTrue(tempPlat.posY < 500f); // A platform of height 500 is always reachable by the player.
    }
}
