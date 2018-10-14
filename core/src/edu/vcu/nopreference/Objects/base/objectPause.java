package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectPause extends objectMenu {

    public objectPause() {
        super();
        render = new Render(this, "pause.jpg");
        sprite.setPosition(0, Gdx.graphics.getHeight() - sprite.getHeight());
    }

    @Override
    public void update() {
    }
    @Override
    protected void initializePhysics()
    {
        physics = new physicsGUI(this);
    }
    @Override
    public void onPressed()
    {
        Gdx.app.log("Untitled", "Game has been paused.");

        Untitled.newScreen = new mainMenu();
    }
}
