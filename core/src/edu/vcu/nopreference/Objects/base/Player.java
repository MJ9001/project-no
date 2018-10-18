package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/10/2018.
 */

public class Player extends objectBase {

    //default constructor creates player as a default image
    public Player()
    {
        render = new Render(this, "badlogic.jpg");
        //sprite.setPosition(0,0);
        setBounds(100, 0, 200, 200);
    }

    //for future character selection support
    public Player(String characterModel, float modelWidth, float modelHeight, float modelX, float modelY){
        render = new Render(this, characterModel);
        setBounds(modelX, modelY, modelWidth, modelHeight);
    }

    @Override
    public void onClick(int x, int y)
    {
        physics.Jump();
    }
}
