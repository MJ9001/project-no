package edu.vcu.nopreference.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

// NONE OF THIS WORKS JUST FUCKIN IGNORE IT
// NONE OF THIS WORKS JUST FUCKIN IGNORE IT
// NONE OF THIS WORKS JUST FUCKIN IGNORE IT
// NONE OF THIS WORKS JUST FUCKIN IGNORE IT
// NONE OF THIS WORKS JUST FUCKIN IGNORE IT
// NONE OF THIS WORKS JUST FUCKIN IGNORE IT
// NONE OF THIS WORKS JUST FUCKIN IGNORE IT

public class buttonManager extends objectBase
{
    Sprite button;

    public buttonManager(String fileName, float posX, float posY, float width, float height)
    {
        //I don't know what is happening because Mark didn't comment his shit
        button = new Sprite(new Texture(Gdx.files.internal(fileName)));
        button.setBounds(posX, posY, width,height);

    }

    public float getX()
    {
        return posX;
    }

    public float getY()
    {
        return posY;
    }

    public boolean boundingTest(float screenX, float screenY)
    {
        if(button.getBoundingRectangle().contains(screenX, screenY))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

