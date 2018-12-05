package edu.vcu.nopreference.Objects.physics;

import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/13/2018.
 */

public class Collision {
    final objectBase object1; //active
    final objectBase object2; //passive
    private float collidedX = 0;//-1 left, 0 none, 1 right
    float collidedY = 0;//-1 down, 0 none, 1 up
    private final boolean collided;
    public Collision(objectBase active, objectBase passive, float CollidedX, float CollidedY, boolean Collided)
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

    public boolean isSolidCollision()
    {
        return object1.physics.isSolid() && object2.physics.isSolid();
    }
}