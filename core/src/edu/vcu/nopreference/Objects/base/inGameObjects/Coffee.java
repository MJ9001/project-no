package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsCoffee;
import edu.vcu.nopreference.Objects.renders.Render;

import java.util.Random;

public class Coffee extends objectBase {
    private static final Random rand = new Random();
    // private int speed = 50;
    public Coffee()
    {
        // Creates the renderer to draw the object at it's location
        render = new Render(this, "coffee.png");
        setBounds(Render.getWidth()+250, Render.getHeight() * rand.nextFloat() * 1f, 138, 180);
    }

    public Coffee(Platform platform) {
        // Creates the renderer to draw the object at it's location
        render = new Render(this, "coffee.png");
        setBounds(0, 0, 138, 180);
        this.posX = platform.posX+250;
        this.posY = platform.posY + sprite.getHeight();
        // speed = (int)platform.getPlatformSpeed();
        updatePosition();
        setDrawOrder(5);
    }


    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update()
    {
        posX -= speedValue;
        updatePosition();
    }

    public void coffeeGrabbed()
    {
        manager.sendIntent("+score", "5");
        toBeDeleted = true;
        System.out.println("Coffee Grabbed!");
    }

    @Override
    // This sets up the physics for the platform to be of type physicsPlatform
    protected void initializePhysics()
    {
        physics = new physicsCoffee(this);
    }
}
