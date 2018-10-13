package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Mark on 10/13/2018.
 */

public class gameObject extends objectBase{
    public gameObject()
    {

    }
    int ticks = 0;
    @Override
    public void update()
    {
        if((ticks % 30) == 0)
        {
            manager.addObject(new Platform());
        }
        ticks++;
    }
    @Override
    public void Draw(SpriteBatch batch) {
    }
}
