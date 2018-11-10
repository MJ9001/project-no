package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectPauseMenu extends objectMenu {//This is the pause menu for some reason
    //constructor of objectMenu
    public objectPauseMenu(){
        super();
        render = new Render(this, "pauseMenu.jpg");
        //anything with sprites ruins unit tests, because libgdx was never designed to be unit tested, so this ugly stuff is what you get
        //until the next iteration when we centralize all sprite manipulation
        sprite.setPosition(render.getWidth()/4, render.getHeight()- sprite.getHeight());

    }

    @Override
    public void onPressed() {
        //if the game is paused, you can interact with the menu
        if(manager.paused){
            inGame.music.dispose();
            Untitled.newScreen = new mainMenu();
        }
    }

    @Override
    public boolean recieveIntent(String Intent, String args)
    {
        if(Intent == "togglepause")
        {
            render.setVisibility((manager.paused = !manager.paused));
            return true;
        }
            return false;
    }
}


