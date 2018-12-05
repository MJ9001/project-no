package edu.vcu.nopreference.Objects.base.inGameObjects.pauseMenu;

import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectPauseMenu extends objectMenu {//This is the pause menu for some reason
    public final returnButton returnBut;
    public final resumeButton resume;

    //constructor of objectMenu
    public objectPauseMenu(){
        super();
        render = new Render(this, "PauseMenu.png");
        //anything with sprites ruins unit tests, because libgdx was never designed to be unit tested, so this ugly stuff is what you get
        //until the next iteration when we centralize all sprite manipulation
        setBounds(Render.getWidth()/2-1800/2, Render.getHeight()/2-1275/2, 1800,1275);

        returnBut = new returnButton(Render.getWidth()/2-1800/2);
        resume = new resumeButton((Render.getWidth()/2-1800/2)+1800);
    }

    public objectMenu getResume(){
        return returnBut;
    }

    @Override
    public void onPressed() {
        //if the game is paused, you can interact with the menu
    }

    @Override
    public void receiveIntent(String Intent, String args)
    {
        if(Intent.equals("togglepause"))
        {
            render.setVisibility((manager.paused = !manager.paused));
            returnBut.toggleVis();
            resume.toggleVis();
        }
    }
}
