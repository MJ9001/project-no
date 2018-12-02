package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectMenu;
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
        render = new Render(this, "PauseMenu.png");
        //anything with sprites ruins unit tests, because libgdx was never designed to be unit tested, so this ugly stuff is what you get
        //until the next iteration when we centralize all sprite manipulation
        setBounds(Render.getWidth()/2-1800/2, Render.getHeight()/2-1275/2, 1800,1275);

    }

    @Override
    public void onPressed() {
        //if the game is paused, you can interact with the menu
        if(manager.paused){
            if(!Render.testing)
            inGame.music.dispose();
            Untitled.newScreen = new mainMenu();
        }
    }

    @Override
    public void receiveIntent(String Intent, String args)
    {
        if(Intent.equals("togglepause"))
        {
            render.setVisibility((manager.paused = !manager.paused));
        }
    }
}

