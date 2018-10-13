package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.physics.physicsBase;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/8/2018.
 */

public class objectBase {
    public Sprite sprite = new Sprite();
    public objectManager manager;
    public physicsBase physics = new physicsBase(this);

    Render render;
    public float posX = 0, posY = 0;
    public objectBase()
    {
        Gdx.app.log("Untitled", "New object created");
    }

    objectBase(Render r)
    {

    }
    public void Draw(SpriteBatch batch) {
        render.draw(batch);
    }
    public void onClick(int x, int y)
    {

    }
    public void onPressed()
    {

    }
    public void update()
    {
        physics.tick();
        //posX+= 0.01f;
        //updatePosition();
    }

    public void updatePosition()
    {
        sprite.setPosition(posX, posY);
    }

    public void setBounds(float x, float y, float width, float height)
    {
        posX = x;
        posY = y;
        sprite.setBounds(x, y, width, height);
    }

}
