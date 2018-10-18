package edu.vcu.nopreference.Objects.base;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.vcu.nopreference.Untitled;
import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;


public class doesItPlatform {

    @Test
    public void doesItMove(){
        Render.testing = true;
        Platform tempPlat = new Platform();
        tempPlat.posX = 500;
        tempPlat.update();
        assertEquals(500 - tempPlat.getPlatformSpeed(), tempPlat.posX, 1.0);
    }

    @Test
    public void amIRandom(){
        Render.testing = true;
        Platform tempPlat = new Platform();
        double tempPos = tempPlat.posY;
        tempPlat = new Platform();
        assertNotEquals(tempPos, tempPlat.posY, 0.0001);
    }

    @Test
    public void canIStep(){
        Render.testing = true;
        assert(true);
    }

}