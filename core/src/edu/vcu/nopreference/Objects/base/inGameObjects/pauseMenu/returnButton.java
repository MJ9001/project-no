package edu.vcu.nopreference.Objects.base.inGameObjects.pauseMenu;

import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.gameOverScreen;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

public class returnButton extends objectMenu {

    public returnButton(float boundX){
        render = new Render(this, "Return_button.png");
        setBounds(boundX+50, 1275/3f, 1024, 512);
        setDrawOrder(102);
        render.setVisibility(false);
    }

    public void toggleVis(){
        render.toggleVisibility();
    }

    @Override
    public void onPressed() {
        //if the game is paused, you can interact with the menu
        if(manager.paused || Untitled.newScreen instanceof gameOverScreen){
            if(!render.testing){
                inGame.music.dispose();
            }
            Untitled.newScreen = new mainMenu();
        }
    }
}