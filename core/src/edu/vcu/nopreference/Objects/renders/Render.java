package edu.vcu.nopreference.Objects.renders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/10/2018.
 */

public class Render {

    objectBase object;
    public Render(objectBase object, String asset)
    {
        this.object = object;
        this.object.sprite = new Sprite(new Texture(Gdx.files.internal(asset)));
    }

    public int draw(SpriteBatch batch)
    {
        object.sprite.draw(batch);
        return 0;//Zero on success
    }
}
