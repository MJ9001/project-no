package edu.vcu.nopreference.Objects.renders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.mainMenu.backgroundObject;
import edu.vcu.nopreference.Objects.base.objectBase;

/**
 * Created by Mark on 10/10/2018.
 */

public class Render {
    //global testing variable used to disable libgdx usage during tests
    public static boolean testing = false;
    private objectBase object;
    private backgroundObject back;

    //overloaded default constructor, does nothing.
    public Render(){

    }
    //constructor used for drawing objects to screen
    public Render(objectBase object, String asset) {
        //This garbage unit test hack will be updated and improved in next iteration
        //headless applications are giving us a lot of trouble and we are all very busy with many classes,
        //so this is the solution we implemented to make tests actually properly test our code.
        //takes object and draws the sprite given the asset passed to it.
        if(!testing){
            this.object = object;
            this.object.sprite = new Sprite(new Texture(Gdx.files.internal(asset)));
        }
    }

    //draws the sprite batch
    public void draw(SpriteBatch batch) {
        if(!testing) {
            //draws the sprite batch
            object.sprite.draw(batch);
        }
    }

    //separate methods because the backgrounds are textures rather than sprites
    public void renderBackground(backgroundObject back){
        if(!testing){
            this.back = back;
            this.back.sprite = new Sprite(back.texture, getWidth(), getHeight());
        }
    }

    public void drawBackground(SpriteBatch batch){
        if(!testing){batch.draw(this.back.texture, 0, 0);}
    }

    //sets the visibility of a given object
    public void setVisibility(boolean vis){
        if(testing) return; //REMOVE
        object.visible=vis;
        if(vis){
            object.sprite.setAlpha(1);
        }
        else{
            object.sprite.setAlpha(0);
        }
    }

    //returns the visibility of a given object
    public boolean getVisibility(){
        return object.visible;
    }

    //toggles the visibility back and forth of a given object
    public void toggleVisibility(){
        if(!testing) {
            if (object.visible) {
                object.sprite.setAlpha(0);
                object.visible = false;
            } else {
                object.sprite.setAlpha(1);
                object.visible = true;
            }
        }
    }

    public float getScreenSizeY(){
        return getHeight();
    }

    public float getScreenSizeX(){
        return getWidth();
    }


    public static int getHeight()
    {
        return testing ? 1000 : Gdx.graphics.getHeight();
    }
    public static int getWidth()
    {
        return testing ? 1000 : Gdx.graphics.getWidth();
    }
    public void clearScreen(){
        if(!testing){
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
    }

}
