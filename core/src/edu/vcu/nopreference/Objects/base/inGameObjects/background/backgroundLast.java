package edu.vcu.nopreference.Objects.base.inGameObjects.background;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundLast extends objectBase {
    private float PARALLAX_SPEED=2;

    public backgroundLast(){
        render = new Render(this, "abclouds.png");
        setBounds(0,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(1);
        physics.setSolid(false);
        this.GUIAsset = true;
        speedValue = 2;
        originalSpeed = speedValue;
    }
    public backgroundLast(float xBound){
        render = new Render(this, "cdclouds.png");
        setBounds(xBound,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(1);
        physics.setSolid(false);
        this.GUIAsset = true;
        speedValue = 2;
        originalSpeed = speedValue;
    }
    @Override
    public void update(){
        posX-=speedValue;
        updatePosition();
    }

    public float getPosX(){
        return posX;
    }

    @Override
    public void updateCollision()//Check collision
    {
    }
}
