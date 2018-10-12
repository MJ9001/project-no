package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.collisions.hitBox;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/8/2018.
 */

public class objectBase {
    public Sprite sprite = new Sprite();

    Render render;
    hitBox hitbox;
    objectBase()
    {
    }
    objectBase(Render r, hitBox h)
    {

    }
    public void Draw(SpriteBatch batch) {
        render.draw(batch);
    }

}
