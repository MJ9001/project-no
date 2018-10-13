package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.vcu.nopreference.Objects.physics.Collision;

/**
 * Created by Mark on 10/10/2018.
 */

public class objectManager {

    List<objectBase> objects = new ArrayList<objectBase>();

    List<objectBase> newObjects = new ArrayList<objectBase>();

    public objectManager()
    {

    }

    public void addObject(objectBase object)
    {
        newObjects.add(object);
        object.manager = this;
    }

    public void drawObjects(SpriteBatch batch) {
        for (objectBase obj : objects) {
            obj.Draw(batch);
        }
    }

    public void logicTick()
    {
        for (objectBase obj : objects) {
            if(obj != null)
            obj.update();
        }
        objects.addAll(newObjects);
        newObjects.clear();
    }
    public void onClick(int x, int y)
    {
        for (objectBase obj : objects) {
            if (obj.sprite.getBoundingRectangle().contains(x, y))
            {
                obj.onPressed();
            }
            obj.onClick(x, y);
        }
    }

    public Collision checkCollision(objectBase object)
    {
        for (objectBase obj : objects) {
            if(object.sprite.getBoundingRectangle().overlaps(obj.sprite.getBoundingRectangle()) && object != obj)
            {
                int xCol = 0;
                int yCol = 0;
                float ax1 = object.sprite.getBoundingRectangle().getX();
                float ax2 = object.sprite.getBoundingRectangle().getWidth() + object.sprite.getBoundingRectangle().getX();
                float px1 = obj.sprite.getBoundingRectangle().getX();
                float px2 = obj.sprite.getBoundingRectangle().getWidth() + obj.sprite.getBoundingRectangle().getX();

                float ay1 = object.sprite.getBoundingRectangle().getY();
                float ay2 = object.sprite.getBoundingRectangle().getHeight() + object.sprite.getBoundingRectangle().getY();
                float py1 = obj.sprite.getBoundingRectangle().getY();
                float py2 = obj.sprite.getBoundingRectangle().getHeight() + obj.sprite.getBoundingRectangle().getY();
                if(ax1 < px2 && ax2 > px1)
                    xCol = 1;//right
                else if(ax2 > px1 && ax1 < px2)
                    xCol = -1; // left


                if(ay1 < py2 && ay2 > py1)
                    yCol = 1;//up
                else if(ay2 > py1 && ay1 < py2)
                    yCol = -1; //down
                return new Collision(object, obj, xCol, yCol, true);
            }
        }
        return null;
    }
}
