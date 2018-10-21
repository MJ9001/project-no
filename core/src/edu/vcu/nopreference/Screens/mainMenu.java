package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.backgroundObject;
import edu.vcu.nopreference.Objects.base.inputHandler;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.base.playButton;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Untitled;

public class mainMenu implements Screen
{
    public static boolean hidden;
    SpriteBatch batch;
    //BitmapFont font = new BitmapFont();
    playButton play ;
    //render for controling libgdx
    Render render = new Render();
    backgroundObject background;
    //manager for all sprites, backrounds and buttons
    objectManager objectman = new objectManager();
    inputHandler input;

    public mainMenu(inputHandler input)
    {
        this.input = input;
        play = new playButton(input);
        //setting up variables to be used
        hidden = false;
        //setting up batch to draw sprites
        batch = new SpriteBatch();
        //creating menu as a texture
        background = new backgroundObject("menu.jpg");
        objectman.addObject(background);
        objectman.addObject(play);
        objectman.updateList();

        input.updateObjectManager(objectman);

        //testing for touching the play  button
        input.inputHandling();
    }
    @Override
    public void show() {
        hidden = false;
    }

    @Override
    public void render(float delta)
    {
        //if the screen is hidden, then no render will occur.
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

    public boolean isShown() {
        return hidden;
    }


    public void fakePress(){
        Untitled.newScreen = new inGame(input);
        hidden = true;
    }
}
