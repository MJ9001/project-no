package edu.vcu.nopreference.Objects.base.levelSelect;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Untitled;

public class levelSelect extends objectBase {
    private boolean levelUnlocked;
    private final float insideX;
    private final float insideY;

    //level select will eventually have modifiers and possible different textures stored for each one,
    //which in turn will be passed via the constructor from the levelManager class. Once
    //a specific level will be pressed, the modifiers and differences between levels will be passed to
    //their respective classes.
    //this is assuming that the only differences between levels will be speed, texture, and essentially no
    //changes to the main game mechanics.

    public levelSelect(float posX, float posY, boolean unlocked/*, float speed*/){
        render = new Render(this, "levelSelectOutline.png");
        setBounds(posX, posY, 306, 306);

        //info used for drawing the inside of the level select icon
        insideX = posX + 10;
        insideY = posY + 10;
        levelUnlocked = unlocked;
    }

    public boolean getUnlocked(){ return levelUnlocked;}

    public levelSelectInner constructInner(String innerAsset){
        return new levelSelectInner(innerAsset, insideX, insideY, this);
    }

    //prevents the object from being affected by gravity and collisions
    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }
    @Override
    public void onPressed() {
        if(levelUnlocked){
            Untitled.newScreen = new inGame();
        }
    }
}
