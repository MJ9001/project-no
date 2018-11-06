package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;

import java.util.Random;

public class objectCoffee extends objectBase {
    private static Random rand = new Random();

    public objectCoffee() {
        // Creates the renderer to draw the object at it's location
        render = new Render(this, "coffeeasset1.jpg");
        if (!Render.testing) setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * rand.nextFloat() * 1f, 500, 100);
        else setBounds(500, rand.nextFloat(), 500, 100);
    }

    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update() {
        updatePosition();
    }

    @Override
    // This sets up the physics for the platform to be of type physicsPlatform
    protected void initializePhysics()
    {
        physics = new physicsPlatform(this);
    }
}
