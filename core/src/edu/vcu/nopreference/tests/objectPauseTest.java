package edu.vcu.nopreference.tests;

import org.junit.Test;

import edu.vcu.nopreference.Objects.base.inGameObjects.Platform;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Untitled;


import static org.junit.Assert.*;

public class objectPauseTest{

    private Untitled game;
    private inGame stage;

    //Given that I am in-game, when I press the pause button, a menu should prompt
    //the user to quit the game and return to the main menu.
    //Testing if inGame pause returns pause and if pressing the pause button actually pauses the game
    @Test
    public void testPause(){
        Render.testing = true;
        objectManager OMTest = new objectManager();
        OMTest.initializeObjects();
        OMTest.logicTick();

        OMTest.onClick(50,50);//Click top left corner.
        assertTrue(OMTest.paused);
    }

    //Given that I am in game, when I look at the top left corner of the screen, I should
    //see a pause button, and when I press the pause button, then a menu should open

    //testing if the pause button will bring up the pause menu, instead of testing the inGame function,
    //the same code that runs the pause button functionality was inserted here.
    @Test
    public void testUnpauseButton(){

        Render.testing = true;
        objectManager OMTest = new objectManager();
        OMTest.initializeObjects();
        OMTest.logicTick();

        OMTest.onClick(50,50);//Click topleft corner.
        assertTrue(OMTest.paused);
        OMTest.onClick(50,50);//Click topleft corner.
        assertFalse(OMTest.paused);
    }

    //Tests that pressing the menu when paused will cause a return to the main menu
    //Given that I am in-game, when I press the pause button, a menu should prompt
    //the user to quit the game and return to the main menu.
    @Test
    public void testPauseQuit(){
        Render.testing = true;
        objectManager OMTest = new objectManager();

        Platform tempPlat = new Platform();
        tempPlat.posX = 500;

        OMTest.onClick(50,50);//Click topleft corner.

        OMTest.logicTick();
        OMTest.logicTick();

        assertEquals(500, tempPlat.posX,1);
    }
}