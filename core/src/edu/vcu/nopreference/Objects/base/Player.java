package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/10/2018.
 */

public class Player extends objectBase {

    float score=255;
    final float maxScore=255;

    //default constructor creates player as a default image
    public Player()
    {
        render = new Render(this, "player_temporary_asset.png");
        //sprite.setPosition(0,0);
        setBounds(100, 0, 200, 200);
    }

    //makes it such that the players score decreases by 0.1 every tick
    //this effects the jump height alone currently, but in the future it will effect other factors as well
    @Override
    public void updateCollision(){
        score-=0.1;
        physics.onCollision(manager.checkCollision(this));
    }

    //for possible future character selection support
    public Player(String characterModel, float modelWidth, float modelHeight, float modelX, float modelY){
        render = new Render(this, characterModel);
        setBounds(modelX, modelY, modelWidth, modelHeight);
    }

    @Override
    public void onClick(int x, int y)
    {
        physics.Jump((score/maxScore));
    }


}
