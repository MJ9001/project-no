package edu.vcu.nopreference.Objects.renders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

        this.player.sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
    }
    @Override
    public int draw(SpriteBatch batch)
    {
        player.sprite.draw(batch);
        //batch.draw(text, 0, 0);
        return 0;
    }
}
