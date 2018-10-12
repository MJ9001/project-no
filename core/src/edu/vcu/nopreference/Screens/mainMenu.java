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
        hidden = false;
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        //camera = new OrthographicCamera(w, h);
        //camera.position.set(w/2, h/2, 0);
        //camera.update();
        batch = new SpriteBatch();
        menu = new Texture("menu.jpg");

        playButton = new Sprite(new Texture(Gdx.files.internal("playButton.jpg")));
        playButton.setBounds(800, 687, 1124,460);
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                if(playButton.getBoundingRectangle().contains(screenX, screenY)) {
                    Gdx.app.log("Untitled", "my informative message" + screenY);
                    Untitled.newScreen = new inGame();
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
        if(hidden) return;
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
}
