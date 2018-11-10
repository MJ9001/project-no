package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.vcu.nopreference.Objects.physics.Collision;
import edu.vcu.nopreference.Screens.inGame;

/**
 * Created by Mark on 10/10/2018.
 */

public class objectManager {

    private List<objectBase> objects = new ArrayList<objectBase>();

    private List<objectBase> newObjects = new ArrayList<objectBase>();

    public objectManager()
    {

    }

    public objectBase getObjectByIndex(int i) {return objects.get(i);}
    public void addObject(objectBase object)
    {
        newObjects.add(object);
        object.manager = this;
    }

    //method used to force an update of the list, used for main menu creation, as there are no ticks used there
    public void updateList(){
        objects.addAll(newObjects);
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

        for (objectBase obj : objects) {
            //if(obj instanceof Player || obj instanceof Obstacle)
                obj.updateCollision();

        }

        //Delete Objects
        List<objectBase> delete_objects = new ArrayList<objectBase>();
        for (objectBase obj : objects) {
                if(obj.toBeDeleted)
                    delete_objects.add(obj);
        }
        objects.removeAll(delete_objects);

        objects.addAll(newObjects);
        newObjects.clear();
    }

    public void sendIntent(String Intent, String Argument)
    {
        for (objectBase obj : objects) {
        obj.recieveIntent(Intent, Argument);
        }

    }

    public void onClick(int x, int y)
    {
        y = Gdx.graphics.getHeight() - y;

        for (objectBase obj : objects) {
            if (obj instanceof objectMenu || obj instanceof playButton) {
                if (obj.sprite.getBoundingRectangle().contains(x, y))
                {
                    obj.onPressed();
                    return;
                }
            }
        }

        for (objectBase obj : objects) {
            if(!inGame.paused || obj instanceof objectPause) {
                if (obj.sprite.getBoundingRectangle().contains(x, y)) {
                    obj.onPressed();
                }
                obj.onClick(x, y);
            }
        }
    }

    //This method is a mess, we'll have to fix it up later. --Mark
    public Collision checkCollision(objectBase object)
    {
        for (objectBase obj : objects) {
            if(object.sprite.getBoundingRectangle().overlaps(obj.sprite.getBoundingRectangle()) && object != obj && !obj.GUIAsset)
            {
                float xCol = 0;
                float yCol = 0;
                float ax1 = object.sprite.getBoundingRectangle().getX();
                float ax2 = object.sprite.getBoundingRectangle().getWidth() + object.sprite.getBoundingRectangle().getX();
                float px1 = obj.sprite.getBoundingRectangle().getX();
                float px2 = obj.sprite.getBoundingRectangle().getWidth() + obj.sprite.getBoundingRectangle().getX();

                float ay1 = object.sprite.getBoundingRectangle().getY();
                float ay2 = object.sprite.getBoundingRectangle().getHeight() + object.sprite.getBoundingRectangle().getY();
                float py1 = obj.sprite.getBoundingRectangle().getY();
                float py2 = obj.sprite.getBoundingRectangle().getHeight() + obj.sprite.getBoundingRectangle().getY();



                if(ax1 < px2 && ax2 > px1)
                    xCol = px2-ax1;//right
                else if(ax2 > px1 && ax1 < px2)
                    xCol = ax2-px1; // left


                if(py2 - ay1 > 0 && ay2 > py1)
                    yCol = py2 - ay1;//up
                else if(ay2 > py1 && ay1 < py2)
                    yCol = ay2-py1; //down
                return new Collision(object, obj, xCol, yCol, true);
            }
        }
        return null;
    }

    //method that uses comparators to sort the list of objects based on draw order. Because of how large this list gets,
    //we will probably have to introduce some garbage collection if we want this solution to continue working
    /*public void sortObjectList(){
        Collections.sort(objects, new objectComparator());
    }*/
}
