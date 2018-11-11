package edu.vcu.nopreference.Objects.physics;

import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectBase;

public class physicsObstacle extends physicsBase {
    public physicsObstacle(objectBase object){
        super(object);
    }

    @Override
    public void onCollision(Collision collision){
        if(collision == null) {
            return;
        }
        if (collision.object1 instanceof Player || collision.object2 instanceof Player){
            if(collision.object1 instanceof Player){
                ((Player) collision.object1).takeDamage();
            }
            else{
                ((Player) collision.object2).takeDamage();
            }
        }
        float percent = object.sprite.getBoundingRectangle().getHeight() * 0.4f;
        if(collision.collidedY < percent && velocityY <= 0)
        {
            onGround = true;
            object.posY = collision.object2.sprite.getBoundingRectangle().getY() + collision.object2.sprite.getBoundingRectangle().getHeight();
            velocityY = 0;
        }

    }
}
