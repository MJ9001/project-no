package edu.vcu.nopreference.Objects.physics;


import edu.vcu.nopreference.Objects.base.inGameObjects.Coffee;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectBase;

public class physicsCoffee extends physicsBase {
    public physicsCoffee(objectBase object) {
        super(object);
    }
    @Override

    public void onCollision(Collision collision)
    {
        if(collision != null)
            if(collision.getObject1() instanceof Player || collision.getObject2() instanceof Player)
                ((Coffee)object).coffeeGrabbed();
    }
}