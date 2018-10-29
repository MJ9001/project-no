/*
 *  This is the platformManager object.
 *
 *
 *
 *
 *  TODO: Cull unnecessary constructor cases.
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
    private float PLATFORM_SPEED = 50;
    private Random theRandom = new Random();

    // Local variables
    private ArrayList<Platform> platformPool = new ArrayList<Platform>();
    private ListIterator<Platform> poolItr = platformPool.listIterator();
    private Player player;
    private int screenWidth, screenHeight;
    private float lowerBound, upperBound, leftBound;
    private int tickCount = 0;

    // WARNING!!!
    // Non-parameterized constructor uses Gdx to set the screenWidth and screenHeight local variables.
    public platformManager(){
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform(PLATFORM_SPEED));
        player = new Player();
        setSpawnBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), player);
    }

    // WARNING!!!
    // Player constructor uses Gdx to set the screenWidth and screenHeight local variables.
    public platformManager(Player player_) {
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform(PLATFORM_SPEED));
        player = player_;
        setSpawnBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), player_);
    }

    public platformManager(Player player_, int screenWidth_, int screenHeight_){
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform(PLATFORM_SPEED));
        player = player_;
        setSpawnBounds(screenWidth_, screenHeight_, player_);
    }

    // WARNING!!!
    // Player and Three-Int constructor uses Gdx to set the screenWidth and screenHeight local variables
    public platformManager(Player player_, int poolSize_, int spawnRate_, int randomness_, int platformSpeed_){
        PLATFORM_SPEED = platformSpeed_;
        PLATFORM_POOL_SIZE = poolSize_;
        PLATFORM_SPAWN_RATE = spawnRate_;
        PLATFORM_MAX_HEIGHT_CHANGE = randomness_;
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform(PLATFORM_SPEED));
        player = player_;
        setSpawnBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), player_);
    }

    // Really useful for testing.
    public platformManager(Player player_, int poolSize_, int spawnRate_, int randomness_, float platformSpeed_, int screenWidth_, int screenHeight_){
        PLATFORM_SPEED = platformSpeed_;
        PLATFORM_POOL_SIZE = poolSize_;
        PLATFORM_SPAWN_RATE = spawnRate_;
        PLATFORM_MAX_HEIGHT_CHANGE = randomness_;
        while (platformPool.size() < PLATFORM_POOL_SIZE) platformPool.add(new Platform(PLATFORM_SPEED));
        player = player_;
        setSpawnBounds(screenWidth_, screenHeight_, player_);
    }

    public final ArrayList<Platform> getPlatformPool() {
        return platformPool;
    }

    private void setSpawnBounds(int screenWidth_, int screenHeight_, Player player_){
        lowerBound = player.sprite.getHeight();
        upperBound = screenHeight_ - platformPool.get(0).sprite.getHeight();
        leftBound = screenWidth_;
    }

    private void generatePlatform() {
        float tempHeight = player.posX + (PLATFORM_MAX_HEIGHT_CHANGE * theRandom.nextFloat());
        if (tempHeight < lowerBound) tempHeight = lowerBound;
        if (tempHeight > upperBound) tempHeight = upperBound;
        try {
            poolItr.next().setPosition(leftBound, tempHeight);
        } catch (NoSuchElementException ex) {
            poolItr = platformPool.listIterator();
        }
    }

    @Override
    public void update() {
        if (tickCount++ > PLATFORM_SPAWN_RATE) {
            generatePlatform();
        }
        for (Platform platform: platformPool) {
            platform.update();
        }
    }
}
