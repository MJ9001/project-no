package edu.vcu.nopreference.Objects.base.inGameObjects;

import java.util.Random;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;

/*
 * Created by Mark on 10/13/2018.
 *
 * Hi! This is Peter and I'm commenting this trash fire. My comments are even worse.
 */

public class Platform extends objectBase {
    private static final Random rand = new Random();  // Create a random number generator so that we have a random height for the height.
    private float PLATFORM_SPEED = 50;     //  The platform speed can be set here and referenced using the getter if needed outside of the class.
    private boolean coffeeCreated = false;

    public void   setPlatformSpeed(float speed) { PLATFORM_SPEED = speed; }
    public float  getPlatformSpeed()          { return  PLATFORM_SPEED; }

    public Platform() {
        // Creates the renderer to draw the object at it's location
        render = new Render(this, "platformfloat.png");
        // TODO: do not set the bounds for the object in the constructor because then during testing we have to Render.testing = true to prevent libgdx call.
        setBounds(Render.getWidth(), Render.getHeight() * rand.nextFloat() * 1f, 500, 100);
        physics.setSolid(true);
    }

    public Platform(float platformSpeed_) {
        render = new Render(this, "platformfloat.png");
        setBounds(0,-1000, 500, 100);
        PLATFORM_SPEED = platformSpeed_;
    }

    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update() {
        posX -= PLATFORM_SPEED;
        updatePosition();
        if(!coffeeCreated && manager != null)
        {

            Coffee coffee = new Coffee(this);
            manager.addObject(coffee);
            coffeeCreated = true;
        }
    }

    @Override
    // This sets up the physics for the platform to be of type physicsPlatform
    protected void initializePhysics()
    {
        physics = new physicsPlatform(this);
    }
}
