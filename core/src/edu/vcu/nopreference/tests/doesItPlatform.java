package edu.vcu.nopreference.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Untitled;
import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;
import sun.rmi.runtime.Log;


public class doesItPlatform {

    @Test
    public void doesItMove() {
        Render.testing = true;
        Platform tempPlat = new Platform();
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

    @Test
    public void canIStep() {
        Render.testing = true;
        objectManager tempOM = new objectManager();

        Platform tempPlat = new Platform();
        tempPlat.posX = 500;
        tempPlat.posY = 100;
        tempOM.addObject(tempPlat);

        Player tempPlayer = new Player();
        tempPlayer.posX = 480;
        tempPlayer.posY = 110;
        tempOM.addObject(tempPlat);

        tempOM.logicTick();
        tempOM.logicTick();

        assertEquals(100, tempOM.getObjectByIndex(1).posY, 1.0);    // Platform is indeed at height of 100.
        assertEquals(100, tempOM.getObjectByIndex(0).posY, 1.0);    // Ya boi tempPlayer is on the platform at height 100.
    }

    @Test
    public void canIFall() {
        Render.testing = true;
        objectManager tempOM = new objectManager();

        Platform tempPlat = new Platform();
        tempPlat.posX = 500;
        tempPlat.posY = 100;
        tempOM.addObject(tempPlat);

        Player tempPlayer = new Player();
        tempPlayer.posX = 100;
        tempPlayer.posY = 200;
        tempOM.addObject(tempPlat);

        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();

        assertNotEquals(tempOM.getObjectByIndex(1).posY, tempOM.getObjectByIndex(0).posY, 1.0);  // Make sure that the player is at a position less than the platform.
    }

    @Test
    public void canIJump(){
        Render.testing = true;
        Player player = new Player();
        player.update();
        player.physics.Jump();
        System.out.println(player.physics.velocityY);
        assertTrue(player.physics.velocityY > 0.1);
    }
}