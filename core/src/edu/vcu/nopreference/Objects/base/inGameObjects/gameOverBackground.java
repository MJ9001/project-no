package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

public class gameOverBackground extends objectBase {
    public gameOverBackground(){
        super();
        render = new Render(this, "gameOver.png");
        setBounds(0,0, render.getScreenSizeX(), render.getScreenSizeY());
        setDrawOrder(1);
    }
}
