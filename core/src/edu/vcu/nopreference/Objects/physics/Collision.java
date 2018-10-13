package edu.vcu.nopreference.Objects.physics;

import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/13/2018.
 */

public class Collision {
    objectBase object1; //active
    objectBase object2; //passive
    int collidedX = 0;//-1 left, 0 none, 1 right
    int collidedY = 0;//-1 down, 0 none, 1 up
    boolean collided;
    public Collision(objectBase active, objectBase passive, int CollidedX, int CollidedY, boolean Collided)
    {
        object1 = active;
        object2 = passive;
        collidedX = CollidedX;
        collidedY = CollidedY;
        collided = Collided;
    }

    public objectBase getObject1() {
        return object1;
    }

    public objectBase getObject2() {
        return object2;
    }

    public int getCollidedX() {
        return collidedX;
    }

    public int getCollidedY() {
        return collidedY;
    }
    public boolean getCollided()
    {
        return collided;
    }
}