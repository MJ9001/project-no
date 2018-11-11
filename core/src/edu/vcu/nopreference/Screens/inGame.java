package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.*;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/12/2018.
 */

public class inGame implements Screen {
    //Spritebatch is the buffer for the display
    SpriteBatch batch;

    //boolean that shows whether this screen is shown or not
    boolean hidden = true;
    //the objectManager is the object that manages other objects, and draws them on the screen.
    objectManager objectman = new objectManager();
    //player object
    public Player player;
    //game object
    gameObject game;
    //current time
    long cTime = System.currentTimeMillis();
    //fps average
    int fps = 0;
    //time used for calculating fps
    long fpsTime = System.currentTimeMillis();
    //pause menu and the pause button
    //objectMenu pauseMenu;
    //objectPause pauseButton = new objectPause();
    //backgroundObject background = new backgroundObject("inGameBackground.jpg");;
    //render variable used to handle libgdx functions
    Render render = new Render();
    //bool value to be used for controlling all pause states throughout the program
    public static Music music;


    //the next thing to implement in terms of this inGame is to have level modifiers that vary speed of things passing,
    //frequency of obstacles and frequency of power ups
    public inGame() {
        //set the visibility of the menu to false because when drawing in a sprite, there is no way to draw it in without making it visible
        if(!Render.testing) {
            music = Gdx.audio.newMusic(Gdx.files.internal("songFull.wav"));
            music.play();
        }
        //Temporarly manually added objects here
        //declaring objects to be used for game stuff
        //background.setDrawOrder(1000);
        //objectman.addObject(background);
        //Gdx.app.log("Untitled", "pause menu vis: " + pauseMenu.getVisibility());
        objectman.initializeObjects();
        batch = new SpriteBatch();
        hidden = false;
        //tests for user input, if input, then call object manager, which then goes through all objects and tests their input.
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                objectman.onClick(screenX, screenY);

                return true;
            }

        });

    }

    //returns the boolean hidden which describes whether this screen is hidden or not
    public boolean isHidden()
    {
        return hidden;
    }

    @Override
    public void show() {
    }

    //loop that handles most of the interaction such as time keeping, testing for pause, and drawing objects
    @Override
    public void render(float delta) {
        if(System.currentTimeMillis() >= cTime + 40) //Game runs at 25 ticks per second. Todo: Figure out how to increase render() speed.
        {
            //cTime is the current time, this will update it
            cTime = System.currentTimeMillis();
            objectman.logicTick();
        }
        if(System.currentTimeMillis() >= fpsTime + 1000)
        {
            Gdx.app.log("Untitled", "Fps: " + fps);
            fps = 0;
            fpsTime = System.currentTimeMillis();
        }
        //render.setVisibility(paused, pauseMenu);
        fps++;
        //objectman.sortObjectList();


        render.clearScreen();

        batch.begin();
        objectman.drawObjects(batch); //Draws every object in the game.
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }

    //public objectPause getPauseButton(){
    //    return pauseButton;
    //}
}
