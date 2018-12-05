package edu.vcu.nopreference.Objects.base.inGameObjects;

import java.util.Random;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsObstacle;
import edu.vcu.nopreference.Objects.renders.Render;

//this class is hacky

public class Obstacle extends objectBase {
    private static Random rand = new Random();


    public Obstacle(){
        render = new Render(this, "obstacletrash.png");
        setBounds(Render.getWidth(), 0, 230, 236);
        setDrawOrder(5);
    }


    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update() {
        posX -= speedValue;
        updatePosition();
    }

    @Override
    // This sets up the physics for the platform to be of type physicsObstacle
    protected void initializePhysics()
    {
        physics = new physicsObstacle(this);
    }

}
