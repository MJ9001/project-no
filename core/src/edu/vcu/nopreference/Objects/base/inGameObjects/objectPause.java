package edu.vcu.nopreference.Objects.base.inGameObjects;



import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectPause extends objectBase {

    //constructor for objectPause
    public objectPause() {
        super();
        //renders the pause icon in the top corner of the screen
        render = new Render(this, "pause.png");

        //0, the height of the screen, minus the height of the image
        setBounds(0, Render.getHeight() - 100, 100, 100);
    }

    @Override
    public void update() {
    }

    //prevents the pause button object from being affected by gravity and collisions
    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }

    //Pauses the game by changing the pause value inGame
    @Override
    public void onPressed() {
        manager.sendIntent("togglepause", "");
    }

}
