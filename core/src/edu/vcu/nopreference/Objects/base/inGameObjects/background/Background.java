package edu.vcu.nopreference.Objects.base.inGameObjects.background;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

public class Background extends objectBase {
    private float PARALLAX_SPEED=10;

    public Background(){
        render = new Render(this, "background.png");
        setBounds(0,0, render.getScreenSizeX(), render.getScreenSizeY());
        physics.setSolid(false);
        this.GUIAsset = true;
    }

    @Override
    public void update(){

    }

    @Override
    public void updateCollision()//Check collision
    {
    }
}