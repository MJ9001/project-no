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

    public static boolean testing = false;
    objectBase object;
    public Render(objectBase object, String asset) {
        //This garbage unit test hack will be updated and improved in next iteration, centralize libgdx functions to a few
        if(!testing) {
            //takes object and draws the sprite given the asset passed to it.
            this.object = object;
            this.object.sprite = new Sprite(new Texture(Gdx.files.internal(asset)));
        }
    }

    public int draw(SpriteBatch batch) {
        if(!testing) {
            //draws the sprite batch
            object.sprite.draw(batch);
            return 0;//Zero on success
        }
        return 0;
    }
}
