package edu.vcu.nopreference.Objects.base.mainMenu;

import javax.swing.Renderer;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.levelSelectMenu;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

public class playButton extends objectBase {
    //object for play button on main menu

    public playButton(){
        render = new Render(this, "Start_button.png");
        setBounds((render.getScreenSizeX()-700)/2, (render.getScreenSizeY()/15), 700,700);
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
