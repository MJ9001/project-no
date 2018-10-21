package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Untitled;

public class levelSelect extends objectBase {
    boolean levelUnlocked;
    float insideX, insideY;
    float speedModifier;
    levelSelectInner inner;

    //level select will eventually have modifiers and possible different textures stored for each one,
    //which in turn will be passed via the constructor from the levelManager class. Once
    //a specific level will be pressed, the modifiers and differences between levels will be passed to
    //their respective classes.
    //this is assuming that the only differences between levels will be speed, texture, and essentially no
    //changes to the main game mechanics.

    public levelSelect(float posX, float posY, boolean unlocked/*, float speed*/){
        render = new Render(this, "levelSelectOutline.jpg");
        setBounds(posX, posY, 306, 306);

        //info used for drawing the inside of the level select icon
        insideX = posX + 10;
        insideY = posY + 10;
        levelUnlocked = unlocked;
    }

    //methods used to lock and unlock levels, will be used in levelManager
    public void levelLocked(){
        levelUnlocked = false;
    }

    public void levelUnlocked(){
        levelUnlocked = true;
    }

    public void constructInner(String innerAsset){
        inner = new levelSelectInner(innerAsset, insideX, insideY);
    }

    //methods used for getting the inside bounds of each level select
    public float getInsideX(){
        return insideX;
    }

    public float getInsideY(){
        return insideY;
    }

    //prevents the object from being affected by gravity and colissions
    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }
    @Override
    public void onPressed() {
        //Gdx.app.log("Untitled", "Game has been paused.");
        if(levelUnlocked){
            //Untitled.newScreen = new inGame(input);
        }
        else{

        }
    }
}
