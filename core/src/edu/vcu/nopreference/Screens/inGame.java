package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    public inGame()
    {

        player = new Player();
        objectman.addObject(player);
        game = new gameObject();
        objectman.addObject(game);

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
    public void render(float delta) {
        if(System.currentTimeMillis() >= cTime + 40)
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
        fps++;
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        objectman.drawObjects(batch);
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
}
