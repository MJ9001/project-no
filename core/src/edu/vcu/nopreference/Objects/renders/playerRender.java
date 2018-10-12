package edu.vcu.nopreference.Objects.renders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.Player;

/**
 * Created by Mark on 10/12/2018.
 */

public class playerRender extends Render {

    Player player;

    public playerRender(Player player)
    {
        this.player = player;

        this.player.sprite.setTexture(new Texture("badlogic.jpg"));

    }
    @Override
    public int draw(SpriteBatch batch)
    {
        player.sprite.draw(batch);
        return 0;
    }
}
