package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/13/2018.
 */

public class Platform extends objectBase {

    public Platform() {
        render = new Render(this, "platform.jpg");
        //sprite.setPosition(0,0);
        Random rand = new Random();
        setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * rand.nextFloat() * 0.2f, 500, 100);
    }

    @Override
        public void update() {
        posX -= 50;
        updatePosition();
    }
}

