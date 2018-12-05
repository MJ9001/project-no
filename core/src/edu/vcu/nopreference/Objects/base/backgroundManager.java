package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.inGameObjects.background.backgroundFirst;
import edu.vcu.nopreference.Objects.base.inGameObjects.background.backgroundLast;
import edu.vcu.nopreference.Objects.base.inGameObjects.background.backgroundMid;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundManager extends objectBase{
    private backgroundLast lastOne;
    private backgroundLast lastTwo;
    private backgroundFirst firstOne;
    private backgroundFirst firstTwo;
    private backgroundMid midOne;
    private backgroundMid midTwo;

    backgroundManager(){
        render = new Render();
    }

    private boolean firstTick = true;
    @Override
    public void update() {
        if (firstTick) {
            lastOne = new backgroundLast();
            lastTwo = new backgroundLast(render.getScreenSizeX());
            manager.addObject(lastOne);
            manager.addObject(lastTwo);
            midOne = new backgroundMid();
            midTwo = new backgroundMid(render.getScreenSizeX());
            manager.addObject(midOne);
            manager.addObject(midTwo);
            firstOne = new backgroundFirst();
            firstTwo = new backgroundFirst(render.getScreenSizeX());
            manager.addObject(firstOne);
            manager.addObject(firstTwo);
            firstTick=false;
        }
        if (lastOne.getPosX() < (0 - render.getScreenSizeX())) {
            lastOne.setBounds(render.getScreenSizeX(), 0, render.getScreenSizeX(), render.getScreenSizeY());

        }
        if (lastTwo.getPosX() < (0 - render.getScreenSizeX())) {
            lastTwo.setBounds(render.getScreenSizeX(), 0, render.getScreenSizeX(), render.getScreenSizeY());
        }
        if(midOne.getPosX() < (20 - render.getScreenSizeX())){
            midOne.setBounds(render.getScreenSizeX(), 0, render.getScreenSizeX(), render.getScreenSizeY());
        }
        if(midTwo.getPosX() < (20 - render.getScreenSizeX())){
            midTwo.setBounds(render.getScreenSizeX(), 0, render.getScreenSizeX(), render.getScreenSizeY());
        }
        if(firstOne.getPosX() < (20 - render.getScreenSizeX())){
            firstOne.setBounds(render.getScreenSizeX(),0, render.getScreenSizeX(), render.getScreenSizeY()/8.5f);
        }
        if(firstTwo.getPosX() < (20 - render.getScreenSizeX())){
            firstTwo.setBounds(render.getScreenSizeX(), 0, render.getScreenSizeX(), (render.getScreenSizeY()/8.5f));
        }
    }

    @Override
    public void Draw(SpriteBatch batch) {
    }
}
