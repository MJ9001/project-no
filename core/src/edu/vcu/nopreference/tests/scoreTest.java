package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.Platform;
import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.Score;
import edu.vcu.nopreference.Objects.base.Coffee;
import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.base.objectPause;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class scoreTest {

    @Test
    public void startGameScore(){
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Player tempPlayer = new Player();
        float testScore = tempPlayer.getScoreObj().getScore();
        assertEquals(230, testScore,0);
    }

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

    @Test
    public void pauseGameScore(){
        Render.testing = true;
        objectManager tempOM = new objectManager();
        Player tempPlayer = new Player();
        objectPause tempPause = new objectPause();
        tempOM.initializeObjects();

        tempOM.sendIntent("togglepause", "");
        tempOM.logicTick();
        tempOM.logicTick();
        tempOM.logicTick();

        float testScore = tempPlayer.getScoreObj().getScore();
        assertEquals(230, testScore,0);
    }

    @Test
    public void testShit() {
        int shit = 777;
        assertEquals(777, shit);
    }
}
