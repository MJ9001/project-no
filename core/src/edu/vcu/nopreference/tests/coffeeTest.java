package edu.vcu.nopreference.tests;


import org.junit.Test;

import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.Score;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class coffeeTest {

    
    @Test
    public void coffeeAddsScore() {
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Platform tempPlat = new Platform();
        tempOM.addObject(tempPlat);
        tempPlat.posX = 500;
        tempPlat.posY = 100;

        tempPlat.setPlatformSpeed(50);
        tempPlat.update();

        Player tempPlayer = new Player();
        tempPlayer.posX = 470;          // Player is not quite above the platform, is slightly to the left.
        tempPlayer.posY = 215;          // By the time the player falls onto the platform, ya boi will be squarely on the platform.
        tempOM.addObject(tempPlayer);   // Add player to object manager.

        tempPlayer.update();
        tempPlayer.update();
        tempPlayer.update();
    }

    }
