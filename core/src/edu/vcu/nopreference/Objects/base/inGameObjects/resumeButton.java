package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.renders.Render;

public class resumeButton extends objectMenu {

    public resumeButton(float boundX){
        render = new Render(this, "Resume_button.png");
        setBounds(boundX-1024,1275/2.8f,1024,512);
        setDrawOrder(103);
        render.setVisibility(false);
    }

    public void toggleVis(){
        render.toggleVisibility();
    }

    @Override
    public void onPressed() {
        //if the game is paused, you can interact with the menu
        if(manager.paused){
            manager.sendIntent("togglepause", "");
        }
    }
}