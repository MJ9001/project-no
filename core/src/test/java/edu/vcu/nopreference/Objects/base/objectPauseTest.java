package edu.vcu.nopreference.Objects.base;

import org.junit.Test;

import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

import static org.junit.Assert.*;

public class objectPauseTest extends GameTest{

    private Untitled game;
    private inGame stage;

    @org.junit.Before
    public void setUp() throws Exception {
        game = new Untitled();
        stage = new inGame();

    }

    @Test
    public void testPause(){
        game.render();
        inGame.paused = true;

        assertTrue(game.getActiveScreen() instanceof mainMenu);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}