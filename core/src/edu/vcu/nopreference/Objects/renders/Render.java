package edu.vcu.nopreference.Objects.renders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.backgroundObject;
import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/10/2018.
 */

public class Render {
    //global testing variable used to disable libgdx usage during tests
    public static boolean testing = false;
    objectBase object;
    backgroundObject back;

    //overloaded default constructor, does nothing.
    public Render(){

    }
    //constructor used for drawing objects to screen
    public Render(objectBase object, String asset) {
        //This garbage unit test hack will be updated and improved in next iteration, centralize libgdx functions to a few
        if(!testing) {
            //takes object and draws the sprite given the asset passed to it.
            this.object = object;
            this.object.sprite = new Sprite(new Texture(Gdx.files.internal(asset)));
        }
    }

    //draws the sprite batch
    public int draw(SpriteBatch batch) {
        if(!testing) {
            //draws the sprite batch
            object.sprite.draw(batch);
        }
        return 0;
    }

    public void renderBackground(backgroundObject back){
        if(!testing){
            this.back = back;
            this.back.sprite = new Sprite(back.texture, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    public int drawBackground(SpriteBatch batch){
        if(!testing){batch.draw(this.back.texture, 0, 0);}
        return 0;
    }

    //sets the visibility of a given object
    public void setVisibility(boolean vis, objectBase object){
        object.visible=vis;
        if(vis){
            object.sprite.setAlpha(1);
        }
        else{
            object.sprite.setAlpha(0);
        }
    }

    //returns the visibility of a given object
    public boolean getVisibility(objectBase object){
        return object.visible;
    }

    //toggles the visibility back and forth of a given object
    public void toggleVisibility(objectBase object){
        if(object.visible){
            object.sprite.setAlpha(0);
            object.visible=false;
        }
        else{
            object.sprite.setAlpha(1);
            object.visible=true;
        }
    }

    public void clearScreen(){
        if(!testing){
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
    }

}
