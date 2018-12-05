package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.inGameObjects.CoffeePowerUp;
import edu.vcu.nopreference.Objects.base.inGameObjects.Obstacle;
import edu.vcu.nopreference.Objects.base.inGameObjects.Score;
import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class powerUpTest {


    @Test
    public void testIncreaseSpeed(){
        Render.testing = true;
        objectManager tempOM = new objectManager();
        tempOM.initializeObjects();
        tempOM.logicTick();

        //decreases the score below the boosted level granted at the start of the game
        int j=0;
        while(100>j++){
            tempOM.logicTick();
        }

        CoffeePowerUp tempPower = new CoffeePowerUp();

        tempOM.addObject(tempPower);

        tempPower.update();

        tempOM.player.posX = 400;
        tempOM.player.posY = 0;
        tempPower.posX = 400;
        tempPower.posY = 5;

        tempOM.logicTick();
        boolean speedEverIncreased= false;
        int i=0;
        while(1000>i++){
            tempOM.logicTick();
            if(objectBase.speedModifier > 1){
                speedEverIncreased = true;
            }
        }
        assertTrue(speedEverIncreased);
    }

    @Test
    public void testInvincible(){
        Render.testing = true;
        objectManager tempOM = new objectManager();
        tempOM.initializeObjects();
        CoffeePowerUp tempPower = new CoffeePowerUp();
        tempOM.addObject(tempPower);
        tempPower.update();
        Obstacle tempObs = new Obstacle();
        tempOM.addObject(tempObs);

        tempOM.player.posX = 400;
        tempOM.player.posY = 0;
        tempPower.posX = 400;
        tempPower.posY = 5;
        tempObs.posX = 500;
        tempObs.posY = 0;

        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();

        assertEquals(Score.START_SCORE - (3 * Score.SCORE_DECAY), tempOM.player.getScoreObj().getScore(), 0.1);
    }

    @Test
    public void testDurationOfPowered(){
        Render.testing = true;
        objectManager tempOM = new objectManager();
        tempOM.initializeObjects();
        CoffeePowerUp tempPower = new CoffeePowerUp();
        tempOM.addObject(tempPower);
        tempPower.update();

        tempOM.player.posX = 400;
        tempOM.player.posY = 0;
        tempPower.posX = 400;
        tempPower.posY = 5;
        tempOM.logicTick();

        int i=0;
        while(50>i++){
            tempOM.logicTick();
            assertTrue(tempOM.player.poweredUp);
        }
        tempOM.logicTick();
        assertTrue(!(tempOM.player.poweredUp));
    }
}
