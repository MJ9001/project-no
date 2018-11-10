package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;

import java.util.Random;

public class Coffee extends objectBase {
    private static Random rand = new Random();

    public Coffee()
    {
        // Creates the renderer to draw the object at it's location
        render = new Render(this, "badlogic.jpg");
        setBounds(render.getWidth(), render.getHeight() * rand.nextFloat() * 1f, 500, 100);

    }

    public Coffee(Platform platform) {
        Gdx.app.log("Untitled", "Starting new coffee");
        // Creates the renderer to draw the object at it's location
        render = new Render(this, "badlogic.jpg");
        setBounds(render.getWidth(), render.getHeight() * rand.nextFloat() * 1f, 500, 100);
        this.posX = platform.posX;
        this.posY = (float)(platform.posY + sprite.getHeight()*1.1);
        updatePosition();
        Gdx.app.log("Untitled", "Created new coffee");
    }


    @Override
    // The updates that happen per tick. Update() is called by the object manager.
    public void update()
    {
        updatePosition();
    }

    public void coffeeGrabbed()
    {
        manager.sendIntent("+score", "100");
        toBeDeleted = true;
    }

    @Override
    // This sets up the physics for the platform to be of type physicsPlatform
    protected void initializePhysics()
    {
        physics = new physicsPlatform(this);
    }
}
