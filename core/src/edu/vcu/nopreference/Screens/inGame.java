package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.Player;
import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Untitled;

/**
 * Created by Mark on 10/12/2018.
 */

public class inGame implements Screen {
    SpriteBatch batch;
    boolean hidden = true;
    objectManager objectman = new objectManager();


    public inGame()
    {

        batch = new SpriteBatch();
        hidden = false;
    }

    public boolean isHidden()
    {
        return hidden;
    }
    @Override
    public void show() {
        objectman.addObject(new Player());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
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
