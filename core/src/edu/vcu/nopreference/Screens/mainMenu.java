package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Untitled;

public class mainMenu implements Screen
{
    boolean hidden = true;
    SpriteBatch batch;
    Texture menu;
    //BitmapFont font = new BitmapFont();
    float w,h;
    OrthographicCamera camera;
    private Sprite playButton;

    public mainMenu()
    {
        //setting up variables to be used
        hidden = false;
        //setting up batch to draw sprites
        batch = new SpriteBatch();
        //creating menu as a texture
        menu = new Texture("menu.jpg");

        //creates a sprite play button, then sets the bounds so that the hitbox of clicking lines up with the sprite itself
        playButton = new Sprite(new Texture(Gdx.files.internal("playButton.jpg")));
        playButton.setBounds(800, 687, 1124,460);
        //testing for touching the play  button
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                //if the play buttons bounded rectangle contains the XY coordinates of the touch location, then a new screen will be launched. In this case, the game screen.
                if(playButton.getBoundingRectangle().contains(screenX, screenY)) {
                    //Gdx.app.log("Untitled", "my informative message" + screenY); //test message
                    //creates a new screen which just launches the game
                    Untitled.newScreen = new inGame();
                    hidden = true;
                }

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
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(menu, 0, 0);
        batch.draw(playButton, 800, 300);
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
        Untitled.newScreen = new inGame();
        hidden = true;
    }
}
