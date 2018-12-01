package edu.vcu.nopreference.Objects.base.mainMenu;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.levelSelectMenu;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

public class playButton extends objectBase {
    //object for play button on main menu

    public playButton(){
        render = new Render(this, "playButton.jpg");
        setBounds(800, 300, 1124,460);
    }

    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }

    public void onPressed() {
        if(!Render.testing)
            mainMenu.music.dispose();
        Untitled.newScreen = new levelSelectMenu();
        mainMenu.hidden = true;
    }
}
