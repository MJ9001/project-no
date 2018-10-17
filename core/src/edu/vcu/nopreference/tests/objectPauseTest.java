package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;
import edu.vcu.nopreference.tests.GameTest;

import static org.junit.Assert.*;

public class objectPauseTest{

    private Untitled game;
    private inGame stage;

    @org.junit.Before
    public void setUp() throws Exception {


    }

    @Test
    public void testPause(){
        inGame.paused = true;

        assertTrue(inGame.paused);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}