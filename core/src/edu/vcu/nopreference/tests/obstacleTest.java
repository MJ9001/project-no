package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.inGameObjects.Obstacle;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Objects.base.inGameObjects.Score;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class obstacleTest {

    //tests to see if colliding a player with an obstacle from the Y direction will cause the player to take damage
    @Test
    public void collideWithObstacle() {
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Obstacle tempObs = new Obstacle();
        tempObs.setObstacleSpeed(0);
        tempOM.addObject(tempObs);
        tempObs.posX = 500;
        tempObs.posY = 100;

        tempObs.update();

        Player tempPlayer = new Player();
        tempPlayer.posX = 750;
        tempPlayer.posY = 300;
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());

        tempOM.logicTick();
        int i = 0;
        boolean scoreEverDecreased = false;
        while(1000 > i++){
            float prevScore = Float.parseFloat(tempOM.requestIntent("score"));
            tempOM.logicTick();
            float newScore = Float.parseFloat(tempOM.requestIntent("score"));
            if(newScore < prevScore)
                scoreEverDecreased = true;
            //System.out.println("Coffee score:" + prevScore +":" + newScore + "--" + tempPlayer.sprite.getX());

            //System.out.println(tempOM.objects.get(1).posX);
        }
        assertTrue(scoreEverDecreased);
    }

    //tests to see if colliding a player with an obstacle from the X direction will cause the player to take damage
    @Test
    public void walkIntoObstacle() {
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
        boolean scoreEverDecreased = false;
        while(1000 > i++){
            float prevScore = Float.parseFloat(tempOM.requestIntent("score"));
            tempOM.logicTick();
            float newScore = Float.parseFloat(tempOM.requestIntent("score"));
            if(newScore < prevScore)
                scoreEverDecreased = true;
            //System.out.println("Coffee score:" + prevScore +":" + newScore + "--" + tempPlayer.sprite.getX());

            //System.out.println(tempOM.objects.get(1).posX);
        }
        assertTrue( scoreEverDecreased);
    }

    //tests to see that the player will jump over an obstacle and not take any damage.
    @Test
    public void jumpOverObstacle() {
        Render.testing = true;

        objectManager tempOM = new objectManager();
        Obstacle tempTacle = new Obstacle();
        tempOM.addObject(tempTacle);
        Player tempPlayer = new Player();
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());
        tempOM.logicTick();

        tempTacle.posX = 400;
        tempTacle.posY = 0;
        tempPlayer.posX = 100;
        tempPlayer.posY = 0;

        tempOM.logicTick();

        tempPlayer.physics.Jump(tempPlayer.getScoreObj().getModifier());

        int i = 0;
        while(i++ < 1000) {
            tempOM.logicTick();
        }
        assertEquals(Score.START_SCORE - (1001 * Score.SCORE_DECAY), tempPlayer.getScoreObj().getScore(), 0.01);
    }
}
