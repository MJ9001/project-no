package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.base.inGameObjects.objectPause;
import edu.vcu.nopreference.Objects.renders.Render;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class scoreTest {

    //tests the starting game score, when a player is added in, asserting that it will be equal to 230
    @Test
    public void startGameScore(){
        Render.testing = true;
        Player tempPlayer = new Player();
        float testScore = tempPlayer.getScoreObj().getScore();
        assertEquals(230, testScore,0);
    }

    //testing that as the game goes on, the score will decrease
    @Test
    public void decreaseGameScore(){ // Reminder that this used to be decrese. Shame on you.
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Player tempPlayer = new Player();
        tempOM.addObject(tempPlayer);
        tempOM.addObject(tempPlayer.getScoreObj());

        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();

        float testScore = tempPlayer.getScoreObj().getScore();
        assertTrue(testScore<230);
    }

    //testing that when the game pauses, the score will stop decreasing
    @Test
    public void pauseGameScore(){
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Player tempPlayer = new Player();
        tempOM.initializeObjects();

        tempOM.onClick((int)(50),50);//Click topleft corner.
        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();

        float testScore = tempPlayer.getScoreObj().getScore();
        assertEquals(230, testScore,0);
    }
}
