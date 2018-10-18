package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import edu.vcu.nopreference.Objects.physics.physicsBase;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;

/*
 * Created by Mark on 10/13/2018.
 *
 * Hi! This is Peter and I'm commenting this trash fire. My comments are even worse.
 */

public class Platform extends objectBase {
    //  The platform speed can be set here and referenced using the getter if needed outside of the class. It's pretty wicked fast broh.
    private static int PLATFORM_SPEED = 50;
    public int getPlatformSpeed() {return PLATFORM_SPEED;}

    // Create a random number generator so that we have a random height for the height.
    private static Random rand = new Random();

    public Platform() {
        // TODO: MARK! PLEASE EXPLAIN!!!
        render = new Render(this, "platform.jpg");
        // TODO: do not set the bounds for the object in the constructor because then during testing we have to Render.testing = true to prevent libgdx call.
        if (!Render.testing) setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * rand.nextFloat() * 1f, 500, 100);
        else posY = rand.nextFloat();
    }

    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update() {
        posX -= PLATFORM_SPEED;
        updatePosition();
    }

    @Override
    // This sets up the physics for the platform to be of type physicsPlatform
    protected void initializePhysics()
    {
        physics = new physicsPlatform(this);
    }
}

