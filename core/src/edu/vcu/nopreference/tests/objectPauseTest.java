package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.base.objectPause;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class objectPauseTest{

    private Untitled game;
    private inGame stage;

    @org.junit.Before
    public void setUp() throws Exception {

    }



    //Testing if inGame pause returns pause and if pressing the pause button actually pauses the game
    @Test
    public void testPause(){
        Render.testing=true;
        objectPause tester = new objectPause();

        //presses button, then asserts pause state of inGame
        tester.onPressed();
        assertTrue(inGame.paused);

        tester.onPressed();
        assertFalse(inGame.paused);
    }

    //testing if the pause button will bring up the pause menu, instead of testing the inGame function,
    //the same code that runs the pause button functionality was inserted here.
    @Test
    public void testPauseButton(){

        Render.testing = true;
        objectMenu tester = new objectMenu();
        objectPause testa = new objectPause();

        testa.onPressed();
        tester.setVisibility(inGame.paused);
        assertTrue(tester.getVisibility());

        testa.onPressed();
        tester.setVisibility(inGame.paused);
        assertFalse(tester.getVisibility());
    }

    //Tests that pressing the menu when paused will cause a return to the main menu
    @Test
    public void testPauseQuit(){
        Render.testing = true;
        objectMenu tester = new objectMenu();
        objectPause testa = new objectPause();

        testa.onPressed();
        assertTrue(tester.fakePress());

        testa.onPressed();
        assertFalse(tester.fakePress());

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}