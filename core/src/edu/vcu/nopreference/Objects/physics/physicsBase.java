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
        velocityY += gravity;
        object.posX += velocityX;
        object.posY += velocityY;
        object.updatePosition();
        onCollision(object.manager.checkCollision(object));
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
        if(collision.collidedY == 1)
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
