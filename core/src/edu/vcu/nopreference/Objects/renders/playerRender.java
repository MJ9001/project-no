package edu.vcu.nopreference.Objects.renders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Mark on 10/12/2018.
 */

public class playerRender extends Render {

    Texture img;
    playerRender()
    {
        img = new Texture("badlogic.jpg");
    }

    @Override
    public int draw(SpriteBatch batch)
    {
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        return 0;
    }
}
