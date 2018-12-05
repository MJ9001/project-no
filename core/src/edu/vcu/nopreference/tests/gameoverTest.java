package edu.vcu.nopreference.tests;

import org.junit.Test;
import edu.vcu.nopreference.Objects.base.inGameObjects.Obstacle;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.gameOverScreen;
import edu.vcu.nopreference.Untitled;
import static org.junit.Assert.assertTrue;

public class gameoverTest {
    @Test
    public void testStayAlive() {
        boolean passed = false;
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Obstacle tmpObstacle = new Obstacle();
        tempOM.addObject(tmpObstacle);
        tmpObstacle.posX = 700;
        tmpObstacle.posY = 5;

        tmpObstacle.update();

        Player tempPlayer = new Player();
        tempPlayer.posX = 100;
        tempPlayer.posY = 0;
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());

        tempOM.logicTick();
        int i = 0;
        while (1000 > i++) {
            float prevScore = Float.parseFloat(tempOM.requestIntent("score"));
            tempOM.logicTick();
            float newScore = Float.parseFloat(tempOM.requestIntent("score"));
            if (newScore < prevScore) {
                passed = !(Untitled.newScreen instanceof gameOverScreen);
                break;
            }
        }
        assertTrue(passed);
    }

    @Test
    public void testDieCollision()
    {

        boolean passed = false;
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Obstacle tmpObstacle = new Obstacle();
        tempOM.addObject(tmpObstacle);
        tmpObstacle.posX = 700;
        tmpObstacle.posY = 5;

        tmpObstacle.update();

        Player tempPlayer = new Player();

        tempPlayer.posX = 100;
        tempPlayer.posY = 0;
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());
        tempOM.sendIntent("setscore", "20");

        tempOM.logicTick();
        int i = 0;
        while (1000 > i++) {
            float prevScore = Float.parseFloat(tempOM.requestIntent("score"));
            tempOM.logicTick();
            float newScore = Float.parseFloat(tempOM.requestIntent("score"));
            if (newScore < prevScore) {
                passed = !(Untitled.newScreen instanceof gameOverScreen);
                System.out.println(i);
                break;
            }
        }
        assertTrue(passed);
    }

    @Test
    public void testDieTick() {
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
}