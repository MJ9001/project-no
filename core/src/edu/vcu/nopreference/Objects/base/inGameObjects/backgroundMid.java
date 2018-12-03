package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundMid extends objectBase {
    private float PARALAX_SPEED=20;

    public backgroundMid(){
        render = new Render(this, "bgbuildings.png");
        setBounds(0,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(2);
        physics.setSolid(false);
        this.GUIAsset = true;
    }

    public backgroundMid(float xBound){
        render = new Render(this, "bgbuildings.png");
        setBounds(xBound,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(1);
        physics.setSolid(false);
        this.GUIAsset = true;
    }

    @Override
    public void update(){
        posX-=PARALAX_SPEED;
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
