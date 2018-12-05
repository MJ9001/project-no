package edu.vcu.nopreference.tests;

import org.junit.Test;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.gameOverScreen;
import edu.vcu.nopreference.Untitled;
import static org.junit.Assert.assertTrue;

public class gameoverTest {
    @Test
    public void testStayAlive()
    {
        Render.testing = true;
        objectManager tempOM = new objectManager(); // Dummy objectManager to run the game simulation

        Player tempPlayer = new Player();
        tempOM.addObject(tempPlayer);   // Add player to object manager.
        tempOM.addObject(tempPlayer.getScoreObj());

        boolean passed = false;
        for(int i = 0; 1000000 > i; i++) {
            if(Untitled.newScreen instanceof gameOverScreen) {
                passed = true;
                break;
            }
            tempOM.logicTick();
        }
        System.out.println(Untitled.newScreen);
        assertTrue(passed);
    }


    @Test
    public void testDieCollision()
    {

    }

    @Test
    public void testDieTick() {

    }
}
