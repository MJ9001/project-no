package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

import edu.vcu.nopreference.Objects.base.inGameObjects.Player;
import edu.vcu.nopreference.Objects.base.inGameObjects.pauseMenu.objectPause;
import edu.vcu.nopreference.Objects.base.inGameObjects.pauseMenu.objectPauseMenu;
import edu.vcu.nopreference.Objects.physics.Collision;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/10/2018.
 */

public class objectManager {
    public Player player;
    public objectPauseMenu pauseMenu;
    public boolean paused = false;
    public final List<objectBase> objects = new ArrayList<objectBase>();

    private final List<objectBase> newObjects = new ArrayList<objectBase>();

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

    public void drawObjects(SpriteBatch batch) {//Items with a higher draw order are drawn last.
        List<objectBase> tempObjects = new ArrayList<objectBase>(objects);
        // tempObjects.addAll(objects);
        List<objectBase> tbdObjects = new ArrayList<objectBase>();
        int currDraw = 0;
        int nextDraw;
        while(!tempObjects.isEmpty()) {
            nextDraw = Integer.MAX_VALUE;
            for (objectBase obj : tempObjects) {
                if(obj.getDrawOrder() == currDraw) {
                    obj.Draw(batch);
                    tbdObjects.add(obj);
                } else
                if(nextDraw > obj.getDrawOrder())
                {
                    nextDraw = obj.getDrawOrder();
                }
            }
            currDraw = nextDraw;
            tempObjects.removeAll(tbdObjects);
            //System.out.println(tempObjects.size());
            tbdObjects.clear();
        }
        //System.out.println("Drawing!");

    }
    public void initializeObjects()
    {
        objectBase.speedModifier = 1f;
        backgroundManager background = new backgroundManager();
        addObject(background);
        player = new Player();
        gameObject game = new gameObject(player);
        player.setDrawOrder(100);
        addObject(player);
        addObject(player.getScoreObj());
        addObject(game);
        objectPause objPause = new objectPause();
        objPause.setDrawOrder(4);
        addObject(objPause);
        pauseMenu =  new objectPauseMenu();
        pauseMenu.render.setVisibility(false);
        addObject(pauseMenu);
        pauseMenu.setDrawOrder(101);
        addObject(pauseMenu.resume);
        addObject(pauseMenu.returnBut);
    }
    public void logicTick()
    {
        if(paused){return;}
        for (objectBase obj : objects) {
            if(obj != null)
            obj.update();
        }

        for (objectBase obj : objects) {
                obj.updateCollision();
                obj.updatePosition();

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
        obj.receiveIntent(Intent, Argument);
        }

    }

    public void onClick(int x, int y)
    {
        int origY = y;
        y = Render.getHeight() - y;

        /*for (objectBase obj : objects) {
            if (obj instanceof objectMenu || obj instanceof playButton) {
                if (obj.sprite.getBoundingRectangle().contains(x, y))
                {
                    obj.onPressed();
                    return;
                }
            }
        }*/

        for (objectBase obj : objects) {
            if(!paused || obj instanceof objectMenu) {
                if (obj.sprite.getBoundingRectangle().contains(x, y)) {
                    obj.onPressed();
                }
                obj.onClick();
            }
        }
    }

    public String requestIntent(String request)
    {
        for (objectBase obj : objects) {
            String response = obj.requestIntent(request);
            if(response != null)
                return response;
        }

        return null;
    }

    public void modifySpeed(float modifier){
        for(objectBase obj : objects){
            obj.updateSpeed(modifier);
        }
    }

    public void resetSpeed(){
        for(objectBase obj : objects){
            obj.resetSpeed();
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
}
