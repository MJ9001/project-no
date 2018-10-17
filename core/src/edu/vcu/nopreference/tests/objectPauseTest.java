package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.base.objectPause;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;
import edu.vcu.nopreference.tests.GameTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class objectPauseTest{

    private Untitled game;
    private inGame stage;

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMainMenuVisibility(){
        //mainMenu mainMenuTest = new mainMenu();
        //assert(true);
    }

    //Testing if inGame pause returns pause
    @Test
    public void testPause(){
        Render.testing=true;
        objectPause tester = new objectPause();
        tester.onPressed();
        assertTrue(inGame.paused);
        tester.onPressed();
        assertFalse(inGame.paused);
    }

    @Test
    public void testPauseButton(){

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}