package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.Coffee;
import edu.vcu.nopreference.Objects.base.Obstacle;
import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.base.objectPause;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class obstacleTest {
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

    @Test
    public void jumpOverCoffee() {
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Platform tempPlat = new Platform();
        tempPlat.setPlatformSpeed(0);
        tempOM.addObject(tempPlat);
        tempPlat.posX = 500;
        tempPlat.posY = 100;

        tempPlat.update();

        Player tempPlayer = new Player();
        tempPlayer.posX = 750;
        tempPlayer.posY = 300;
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());
        tempOM.logicTick();

        int i = 0;
        boolean scoreEverIncreased = false;
        while(1000 > i++) {
            float prevScore = Float.parseFloat(tempOM.requestIntent("score"));
            tempOM.logicTick();
            float newScore = Float.parseFloat(tempOM.requestIntent("score"));
            if(newScore > prevScore)
                scoreEverIncreased = true;


            //System.out.println("Coffee score:" + prevScore +":" + newScore + "--" + tempPlayer.sprite.getX());
            //System.out.println(tempOM.objects.get(1).posX);
        }
        assertTrue( scoreEverIncreased);
    }

}
