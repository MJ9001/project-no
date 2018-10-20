package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import edu.vcu.nopreference.Objects.base.*;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Untitled;

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
    Player player;
    //game object
    gameObject game;
    //current time
    long cTime = System.currentTimeMillis();
    //fps average
    int fps = 0;
    //time used for calculating fps
    long fpsTime = System.currentTimeMillis();
    //pause menu and the pause button
    objectMenu pauseMenu= new objectMenu();
    objectPause pauseButton = new objectPause();
    backgroundObject background = new backgroundObject("inGameBackground.jpg");;
    //render variable used to handle libgdx functions
    Render render = new Render();
    //bool value to be used for controlling all pause states throughout the program
    public static boolean paused = false;

    public inGame() {
        //set the visibility of the menu to false because when drawing in a sprite, there is no way to draw it in without making it visible
        render.setVisibility(false, pauseMenu);

        //Temporarly manually added objects here
        //declaring objects to be used for game stuff
        player = new Player();
        player.setDrawOrder(1);
        objectman.addObject(player);
        game = new gameObject();
        objectman.addObject(pauseButton);
        pauseButton.setDrawOrder(2);


        objectman.addObject(game);
        objectman.addObject(pauseMenu);
        pauseMenu.setDrawOrder(3);
        //background.setDrawOrder(1000);
        //objectman.addObject(background);
        //Gdx.app.log("Untitled", "pause menu vis: " + pauseMenu.getVisibility());

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
        if(System.currentTimeMillis() >= cTime + 40 && !paused) //Game runs at 25 ticks per second. Todo: Figure out how to increase render() speed.
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
        render.setVisibility(paused, pauseMenu);
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

    public objectPause getPauseButton(){
        return pauseButton;
    }

    public boolean isPaused(){
        return paused;
    }

}
