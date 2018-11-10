package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.physics.Collision;
import edu.vcu.nopreference.Objects.renders.Render;

public class levelManager extends objectManager {
    Render render = new Render();
    public levelManager(){

        //start x and y are just the size with which the loop will add to nextX and nextY
        //after one completed inner loop, the nextX will reset
        float startX = ((render.getScreenSizeX())/6);
        float startY = ((render.getScreenSizeY())/4);
        float nextX = startX;
        float nextY = startY;

        //for right now there is no functionality of getting levels to unlock, but
        //eventually this will be an array of each level's locked/unlocked status
        boolean locked;
        //String levelName will also be an array. This one holds the names of the assets for the
        //graphics inside of the little boxes.
        String levelName;

        for(int count=1; count<3; count++){
            for(int counter=1; counter<6;counter++){
                if(count==2){
                    locked = true;
                }
                else{
                    locked = false;
                }

                levelSelect level = new levelSelect(nextX, nextY, locked);
                addObject(level);
                levelSelectInner inner = level.constructInner("unlock.jpg");
                addObject(inner);

                nextX += startX;
                //Gdx.app.log("Untitled", "X: " + nextX + "Y: " + nextY);
            }
            nextX = startX;
            nextY += startY;
        }
    }

    /*@Override
    public void drawObjects(SpriteBatch batch){
        for(int i=0; i<10;i++){

        }
    }*/


    @Override
    public Collision checkCollision(objectBase object){
        return null;
    }

    @Override
    public void logicTick(){

    }
}
