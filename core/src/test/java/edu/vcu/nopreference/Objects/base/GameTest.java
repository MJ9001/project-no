package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class GameTest {
    private static Application application;

    @BeforeClass
    public static void init() {
        HeadlessApplicationConfiguration conf = new HeadlessApplicationConfiguration();
        application = new HeadlessApplication(new ApplicationListener() {
            @Override public void create() {}
            @Override public void resize(int width, int height) {}
            @Override public void render() {}
            @Override public void pause() {}
            @Override public void resume() {}
            @Override public void dispose() {}
        }, conf);

        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
        Gdx.graphics = Mockito.mock(Graphics.class);
        when(Gdx.graphics.getWidth()).thenReturn(1000);
        when(Gdx.graphics.getHeight()).thenReturn(1000);
    }

    @AfterClass
    public static void cleanUp() {
        // Exit the application first
        application.exit();
        application = null;
    }
}
