package edu.vcu.nopreference.Objects.physics;

import com.badlogic.gdx.Gdx;

import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/10/2018.
 */

public class physicsBase {
    float gravity = (float) -10;
    objectBase object;
    boolean onGround = false;
    public float velocityX = 0, velocityY = 0;
    public physicsBase(objectBase object)
    {
        this.object = object;
    }
    public void tick() {
        onGround = false;
        velocityY += gravity;
        object.posX += velocityX;
        object.posY += velocityY;
        object.updatePosition();
        if(object.posY <= 0)
        {
            onGround = true;
            velocityY = 0;
            object.posY = 0;
        }
    }

    void updatePosition()
    {

    }

    public void onCollision(Collision collision)
    {
        if(collision == null)
            return;
        Gdx.app.log("Untitled", "Collided! X: " + collision.collidedX + " Y: " + collision.collidedY);
        float percent = object.sprite.getBoundingRectangle().getHeight() * 0.4f;
        if(collision.collidedY < percent && velocityY <= 0)
        {
            onGround = true;
            object.posY = collision.object2.sprite.getBoundingRectangle().getY() + collision.object2.sprite.getBoundingRectangle().getHeight();
            velocityY = 0;
        }
    }

    public void Jump()
    {
        if(onGround)
        {
            velocityY = 100;
            onGround = false;
        }
    }
}
