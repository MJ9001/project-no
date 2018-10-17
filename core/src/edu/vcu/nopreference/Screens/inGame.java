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
import edu.vcu.nopreference.Untitled;

/**
 * Created by Mark on 10/12/2018.
 */

public class inGame implements Screen {
    SpriteBatch batch;
    boolean hidden = true;
    objectManager objectman = new objectManager();
    Player player;
    gameObject game;
    long cTime = System.currentTimeMillis();
    int fps = 0;
    long fpsTime = System.currentTimeMillis();
    objectMenu pauseMenu= new objectMenu();
    objectPause pauseButton = new objectPause();
    //bool value to be used for
    public static boolean paused = false;

    public inGame()
    {
        pauseMenu.setVisibility(false);

        //Temporarly manually added objects here
        player = new Player();
        objectman.addObject(player);
        game = new gameObject();
        objectman.addObject(pauseButton);

        objectman.addObject(game);
        objectman.addObject(pauseMenu);
        Gdx.app.log("Untitled", "pause menu vis: " + pauseMenu.getVisibility());

        batch = new SpriteBatch();
        hidden = false;
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                objectman.onClick(screenX, screenY);

                return true;
            }

        });

    }

    public boolean isHidden()
    {
        return hidden;
    }
    @Override
    public void show() {
    }
    @Override
    public void render(float delta)
    {
        if(System.currentTimeMillis() >= cTime + 40 && !paused) //Game runs at 25 ticks per second. Todo: Figure out how to increase render() speed.
        {
            cTime = System.currentTimeMillis();
            objectman.logicTick();
        }
        if(System.currentTimeMillis() >= fpsTime + 1000)
        {
            //Gdx.app.log("Untitled", "Fps: " + fps);
            fps = 0;
            fpsTime = System.currentTimeMillis();
        }
        pauseMenu.setVisibility(paused);
        fps++;
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
