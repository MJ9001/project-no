package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundObject extends objectBase {
    public Texture texture;
    Render render = new Render();

    public backgroundObject(){
        super();
        if(!render.testing)
        {
            texture = new Texture("menu.jpg");
            render.renderBackground(this);
            sprite.setPosition(0, 0);
        }
    }
    @Override
    public void Draw(SpriteBatch batch) {
        render.drawBackground(batch);
    }

    @Override
    public void update(){

    }

    //prevents the pause button object from being affected by gravity and colissions
    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }

}
