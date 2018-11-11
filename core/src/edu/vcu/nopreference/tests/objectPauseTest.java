package edu.vcu.nopreference.tests;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import edu.vcu.nopreference.Objects.base.inputHandler;
import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.base.objectManager;
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



    //Given that I am in-game, when I press the pause button, a menu should prompt
    //the user to quit the game and return to the main menu.
    //Testing if inGame pause returns pause and if pressing the pause button actually pauses the game
    @Test
    public void testPause(){
        Render.testing = true;
        objectManager OMTest = new objectManager();
        OMTest.initializeObjects();
        OMTest.logicTick();
        objectPause fakePause = new objectPause();

        OMTest.onClick((int)(50),50);//Click topleft corner.
        assertTrue(OMTest.paused);
    }

    //Given that I am in game, when I look at the top left corner of the screen, I should
    //see a pause button, and when I press the pause button, then a menu should open

    //testing if the pause button will bring up the pause menu, instead of testing the inGame function,
    //the same code that runs the pause button functionality was inserted here.
    @Test
    public void testUnpaseButton(){

        Render.testing = true;
        objectManager OMTest = new objectManager();
        OMTest.initializeObjects();
        OMTest.logicTick();
        objectPause fakePause = new objectPause();

        OMTest.onClick((int)(50),50);//Click topleft corner.
        assertTrue(OMTest.paused);
        OMTest.onClick((int)(50),50);//Click topleft corner.
        assertFalse(OMTest.paused);
    }

    //Tests that pressing the menu when paused will cause a return to the main menu
    //Given that I am in-game, when I press the pause button, a menu should prompt
    //the user to quit the game and return to the main menu.
    @Test
    public void testPauseQuit(){
        Render.testing = true;
        objectManager OMTest = new objectManager();
        OMTest.initializeObjects();
        OMTest.logicTick();
        objectPause fakePause = new objectPause();

        OMTest.onClick((int)(50),50);//Click topleft corner.
        OMTest.logicTick();

        OMTest.onClick(Render.getWidth()/2, Render.getHeight()/2);//Click topleft corner.
        assertTrue(Untitled.newScreen instanceof mainMenu);
    }

    /*@org.junit.After
    public void tearDown() throws Exception {
    }

    private static Application application;

    @BeforeClass
    public static void init() {
        // Note that we don't need to implement any of the listener's methods
        application = new HeadlessApplication(new ApplicationListener() {
            @Override public void create() {}
            @Override public void resize(int width, int height) {}
            @Override public void render() {}
            @Override public void pause() {}
            @Override public void resume() {}
            @Override public void dispose() {}
        });

        // Use Mockito to mock the OpenGL methods since we are running headlessly
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
    }*/
}