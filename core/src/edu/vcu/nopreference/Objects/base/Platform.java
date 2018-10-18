package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import edu.vcu.nopreference.Objects.physics.physicsBase;
import edu.vcu.nopreference.Objects.physics.physicsPlatform;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/13/2018.
 */

public class Platform extends objectBase {
    private static int PLATFORM_SPEED = 50;
    public int getPlatformSpeed() {return PLATFORM_SPEED;}

    public Platform() {
        render = new Render(this, "platform.jpg");
        //sprite.setPosition(0,0);
        Random rand = new Random();
        if (!Render.testing) setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * rand.nextFloat() * 1f, 500, 100);
    }

    @Override
        public void update() {
        posX -= PLATFORM_SPEED;
        updatePosition();
    }
    @Override
    protected void initializePhysics()
    {
        physics = new physicsPlatform(this);
    }
}

