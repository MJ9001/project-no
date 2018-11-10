package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import edu.vcu.nopreference.Objects.physics.physicsObstacle;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;

//My motivation to do anything is at an all time low so this hacky class is what yall get for now

public class Obstacle extends objectBase {
    private static Random rand = new Random();
    private float OBSTACLE_SPEED = 50;

    public Obstacle(){
        render = new Render(this, "spike.png");
        if (!Render.testing){
            setBounds(Gdx.graphics.getWidth(), 0, 119, 230);

        }
        else {setBounds(500, rand.nextFloat(), 500, 100);}

    }

    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update() {
        posX -= OBSTACLE_SPEED;
        updatePosition();
    }

    @Override
    // This sets up the physics for the platform to be of type physicsObstacle
    protected void initializePhysics()
    {
        physics = new physicsObstacle(this);
    }

}