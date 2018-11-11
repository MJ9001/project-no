package edu.vcu.nopreference.tests;


import org.junit.Test;

import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.Score;
import edu.vcu.nopreference.Objects.base.Coffee;
import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class  coffeeTest {

    //testing that if you are to fall into a coffee object, the object will be picked up and consumed
    @Test
    public void fallIntoCoffee() {
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
        while(1000 > i++){
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

    //testing that when you walk directly into a coffee object, the coffee object will be consumed
    @Test
    public void walkIntoCoffee() {
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Coffee tmpCoffee = new Coffee();
        tempOM.addObject(tmpCoffee);
        tmpCoffee.posX = 700;
        tmpCoffee.posY = 5;

        tmpCoffee.update();

        Player tempPlayer = new Player();
        tempPlayer.posX = 100;
        tempPlayer.posY = 0;
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());

        tempOM.logicTick();
        int i = 0;
        boolean scoreEverIncreased = false;
        while(1000 > i++){
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

    //testing that asserts that if a player is to jump over a coffee object, that object will not be consumed
    @Test
    public void jumpOverCoffee() {
        Render.testing = true;

        objectManager tempOM = new objectManager();
        Coffee tempCoffee = new Coffee();
        tempOM.addObject(tempCoffee);
        Player tempPlayer = new Player();
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());
        tempOM.logicTick();

        tempCoffee.posX = 400;
        tempCoffee.posY = 0;
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
