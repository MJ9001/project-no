package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Mark on 10/10/2018.
 */

public class objectManager {

    List<objectBase> objects = new ArrayList<objectBase>();

    public objectManager()
    {

    }

    public void addObject(objectBase object)
    {
        objects.add(object);
    }

    public void drawObjects(SpriteBatch batch) {
        for (objectBase obj : objects) {
            obj.Draw(batch);
        }
    }

    public void physicsTick()
    {

    }
}
