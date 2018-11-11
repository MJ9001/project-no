package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.levelSelect.levelManager;
import edu.vcu.nopreference.Objects.renders.Render;

public class levelSelectMenu implements Screen{
    SpriteBatch batch;
    Render render = new Render();
    public static boolean hidden;
    levelManager levelman = new levelManager();

    public levelSelectMenu() {
        hidden = false;
        levelman.updateList();

        if (!render.testing){
            batch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                levelman.onClick(screenX, screenY);

                return true;
            }

        });
    }

    }



    @Override
    public void render(float delta)
    {
        //if the screen is hidden, then no render will occur.
        if(hidden) return;
        //using batch to draw the assets

        render.clearScreen();

        batch.begin();
        levelman.drawObjects(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void show() {

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
