package edu.vcu.nopreference.Objects.physics;

import edu.vcu.nopreference.Objects.base.inGameObjects.CoffeePowerUp;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.objectBase;

public class physicsPowerUp extends physicsBase{

    public physicsPowerUp(objectBase object) {
        super(object);
    }

    @Override
    public void onCollision(Collision collision){
        if(collision != null){
            if(collision.getObject1() instanceof Player || collision.getObject2() instanceof Player){
                ((CoffeePowerUp)object).CoffeePowerUpGrabbed();

            }
        }
    }
}
