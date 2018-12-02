package edu.vcu.nopreference.Objects.base;


import edu.vcu.nopreference.Objects.physics.physicsGUI;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectMenu extends objectBase {//This is the pause menu for some reason
    //constructor of objectMenu
    protected objectMenu(){
        super();

    }

    @Override
    public void update() {
    }
    @Override
    protected void initializePhysics() {
        //line of code that prevents object from falling
        GUIAsset = true;
        physics = new physicsGUI(this);
    }
}


