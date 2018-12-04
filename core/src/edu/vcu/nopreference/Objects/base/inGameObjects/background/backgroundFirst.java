package edu.vcu.nopreference.Objects.base.inGameObjects.background;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundFirst extends objectBase {
    //private float PARALAX_SPEED=50;

    public backgroundFirst(){
        render = new Render(this, "ground.png");
        setBounds(0,0, render.getScreenSizeX(), render.getScreenSizeY()/8.5f);
        setDrawOrder(3);
        physics.setSolid(false);
        this.GUIAsset = true;
    }
    public backgroundFirst(float xBound){
        render = new Render(this, "ground.png");
        setBounds(xBound,0, render.getScreenSizeX(), render.getScreenSizeY()/8.5f);
        setDrawOrder(3);
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
