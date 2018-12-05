package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.inGameObjects.gameOverBackground;
import edu.vcu.nopreference.Objects.base.inGameObjects.pauseMenu.returnButton;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.renders.Render;

public class gameOverScreen implements Screen {
    private static boolean hidden;
    private SpriteBatch batch;
    //render for controlling libgdx
    private final Render render = new Render();
    //manager for all sprites, backgrounds and buttons
    private final objectManager objectman = new objectManager();

    public gameOverScreen(){
        if(!Render.testing)
            initalizeGdxStuff();
        returnButton mainMenuReturn = new returnButton(render.getScreenSizeX()/2);
        mainMenuReturn.toggleVis();
        gameOverBackground background = new gameOverBackground();
        hidden = false;
        objectman.addObject(mainMenuReturn);
        objectman.addObject(background);
        objectman.updateList();
    }

    private void initalizeGdxStuff()
    {
        //setting up batch to draw sprites
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                objectman.onClick(screenX, screenY);

                return true;
            }

        });
    }

    @Override
    public void show() {
        hidden = false;
    }

    @Override
    public void render(float delta)
    {
        if(hidden) return;
        //using batch to draw the assets

        render.clearScreen();

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
        hidden = true;
    }

    @Override
    public void dispose() {

    }
}
