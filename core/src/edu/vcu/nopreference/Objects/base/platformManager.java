/*
 *  This is the platformManager object.
 *
 *
 *
 *
 * TODO: Cull unnecessary constructor cases.
 *
 */

package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class platformManager extends objectBase {
    // Constants
    private int PLATFORM_POOL_SIZE = 10;
    private int PLATFORM_SPAWN_RATE = 30;
    private int PLATFORM_MAX_HEIGHT_CHANGE = 100;
    private Random theRandom = new Random();

    // Local variables
    private ArrayList<Platform> platformPool = new ArrayList<Platform>();
    private ListIterator<Platform> poolItr = platformPool.listIterator();
    private Player player;
    private int screenWidth, screenHeight;
    private int tickCount = 0;
    private int previousHeight = 0;

    // WARNING!!!
    // Non-parameterized constructor uses Gdx to set the screenWidth and screenHeight local variables.
    public platformManager(){
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform());
        player = new Player();
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }

    // WARNING!!!
    // Player constructor uses Gdx to set the screenWidth and screenHeight local variables.
    public platformManager(Player player_) {
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform());
        player = player_;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }

    // WARNING!!!
    // Player and Three-Int constructor uses Gdx to set the screenWidth and screenHeight local variables
    public platformManager(Player player_, int poolSize_, int spawnRate_, int randomness_){
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform());
        player = player_;
        PLATFORM_POOL_SIZE = poolSize_;
        PLATFORM_SPAWN_RATE = spawnRate_;
        PLATFORM_MAX_HEIGHT_CHANGE = randomness_;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }

    // Really useful for testing.
    public platformManager(Player player_, int poolSize_, int spawnRate_, int randomness_, int screenWidth_, int screenHeight_){
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform());
        player = player_;
        PLATFORM_POOL_SIZE = poolSize_;
        PLATFORM_SPAWN_RATE = spawnRate_;
        PLATFORM_MAX_HEIGHT_CHANGE = randomness_;
        screenWidth = screenWidth_;
        screenHeight = screenHeight_;
    }

    @Override
    public void update() {
        if (tickCount++ > PLATFORM_SPAWN_RATE) {
            float tempHeight = player.posX + (PLATFORM_MAX_HEIGHT_CHANGE * theRandom.nextFloat());
            if (tempHeight < player.sprite.getHeight())
                tempHeight = player.sprite.getHeight();
            if (tempHeight > screenHeight - player.sprite.getHeight())
                tempHeight -= player.sprite.getHeight();
            try {
                poolItr.next().setPosition(screenWidth, tempHeight);
            } catch (NoSuchElementException ex) {
                poolItr = platformPool.listIterator();
            }
        }
        for (Platform platform: platformPool) {
            platform.update();
        }
    }
}
