package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectMenu extends objectBase {//This is the pause menu for some reason
    //constructor of objectMenu
    public objectMenu(){
        super();

    }

    @Override
    public void update() {
    }
    @Override
    protected void initializePhysics() {
        //line of code that prevents object from falling
        GUIAsset=true;
        physics = new physicsGUI(this);
    }
}


