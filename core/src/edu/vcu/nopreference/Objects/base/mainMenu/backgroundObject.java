package edu.vcu.nopreference.Objects.base.mainMenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;

public class backgroundObject extends objectBase {
    public Texture texture;
    private final Render render = new Render();

    public backgroundObject(){
        super();
        if(!Render.testing)
        {
            texture = new Texture("Menu_Title.png");
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

    //prevents the pause button object from being affected by gravity and collisions
    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }
}