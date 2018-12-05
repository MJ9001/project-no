package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.inGameObjects.Obstacle;
import edu.vcu.nopreference.Objects.base.inGameObjects.Platform;
import edu.vcu.nopreference.Objects.base.inGameObjects.Player;

/**
 * Created by Mark on 10/13/2018.
 */

public class gameObject extends objectBase{
    private final Player player;

    gameObject(Player player_) {
        player = player_;
    }
    private int ticks = 0;
    @Override
    public void update() {
        if((ticks % 27) == 0) {
            manager.addObject(new Platform(player));
        }
        if(((ticks % 120) == 0)||((ticks % 90) == 0)){
            manager.addObject(new Obstacle());
        }
        ticks++;
    }
    @Override
    public void Draw(SpriteBatch batch) {
    }
}
