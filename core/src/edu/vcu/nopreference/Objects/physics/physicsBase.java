package edu.vcu.nopreference.Objects.physics;

import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/10/2018.
 */

public class physicsBase {
    private static final float JUMP_VELOCITY = 120f;
    private static final float JUMP_VARIATION = 25f;

    final objectBase object;
    boolean onGround = false;
    boolean solid = false;
    public float velocityY = 0;
    public physicsBase(objectBase object)
    {
        this.object = object;
    }
    public void tick() {
        onGround = false;
        float gravity = (float) -10;
        velocityY += gravity;
        float velocityX = 0;
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

    public void onCollision(Collision collision)
    {
        if(collision == null)
            return;
        //if(!Render.testing) Gdx.app.log("Untitled", "Collided! X: " + collision.collidedX + " Y: " + collision.collidedY);
        float percent = object.sprite.getBoundingRectangle().getHeight() * 0.8f;
        if(collision.collidedY < percent && velocityY <=  0 && collision.isSolidCollision())
        {
            onGround = true;
            object.posY = collision.object2.sprite.getBoundingRectangle().getY() + collision.object2.sprite.getBoundingRectangle().getHeight();
            velocityY = 0;
        }
    }

    public void Jump(float speed)
    {
        if(onGround)
        {
            velocityY = JUMP_VELOCITY + (speed * JUMP_VARIATION);
            onGround = false;
        }
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
}
