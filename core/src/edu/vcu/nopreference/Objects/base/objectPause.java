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

    //constructor for objectPause
    public objectPause() {
        super();
        //renders the pause icon in the top corner of the screen
        render = new Render(this, "pause.jpg");

        //0, the height of the screen, minus the height of the image
        if(!Render.testing){sprite.setPosition(0, Gdx.graphics.getHeight() - sprite.getHeight());}
    }

    @Override
    public void update() {
    }

    //prevents the pause button object from being affected by gravity and colissions
    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }

    //Pauses the game by changing the pause value inGame
    @Override
    public void onPressed() {
        //Gdx.app.log("Untitled", "Game has been paused.");
        inGame.paused = !inGame.paused;
    }

}
