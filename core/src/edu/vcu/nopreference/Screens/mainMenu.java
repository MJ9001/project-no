package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.backgroundObject;
import edu.vcu.nopreference.Objects.base.objectManager;
import edu.vcu.nopreference.Objects.base.mainMenu.playButton;
import edu.vcu.nopreference.Objects.renders.Render;

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
    public objectManager objectman = new objectManager();
    public static Music music;




    public mainMenu()
    {
        if(!Render.testing)
            initalizeGdxStuff();
        play = new playButton();
        //setting up variables to be used
        hidden = false;
        //creating menu as a texture
        background = new backgroundObject();
        objectman.addObject(background);
        objectman.addObject(play);
        objectman.updateList();



        //testing for touching the play  button
        //input.inputHandling();
    }

    void initalizeGdxStuff()
    {
        //setting up batch to draw sprites
        batch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("songIntro.wav"));
        music.play();
        //this is unnecessary and I will get rid of it eventually, I am
        //a little busy right now just trying to get some other functionality done
        //but it won't be here forever I promise
        //input.updateObjectManager(objectman);

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
        hidden = true;
    }
}
