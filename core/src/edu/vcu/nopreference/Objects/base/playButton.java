package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

public class playButton extends objectBase {
    //object for play button on main menu
    inputHandler input;

    public playButton(inputHandler input){
        this.input = input;
        render = new Render(this, "playButton.jpg");
        setBounds(800, 300, 1124,460);
    }

    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }

    public void onPressed() {
        Untitled.newScreen = new inGame(input);
        mainMenu.hidden = true;
    }
}
