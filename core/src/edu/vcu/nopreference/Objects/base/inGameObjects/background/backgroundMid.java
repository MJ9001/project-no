package edu.vcu.nopreference.Objects.base.inGameObjects.background;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundMid extends objectBase {

    public backgroundMid(){
        render = new Render(this, "bgbuildings.png");
        setBounds(0,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(2);
        speedValue = 20;
        originalSpeed = speedValue;
        physics.setSolid(false);
        this.GUIAsset = true;
    }

    public backgroundMid(float xBound){
        render = new Render(this, "bgbuildings.png");
        setBounds(xBound,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(1);
        speedValue = 20;
        originalSpeed = speedValue;
        physics.setSolid(false);
        this.GUIAsset = true;
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
