package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/10/2018.
 */

public class Player extends objectBase {
    private boolean takingDamage=false;
    private final Score score = new Score();
    public static boolean poweredUp = false;

    //default constructor creates player as a default image
    public Player()
    {
        render = new Render(this, "player_temporary_asset.png");
        //sprite.setPosition(0,0);
        setBounds(100, 0, 200, 200);
        physics.setSolid(true);
        setDrawOrder(10);
    }

    //makes it such that the players score decreases by 0.1 every tick
    //this effects the jump height alone currently, but in the future it will effect other factors as well
    @Override
    public void updateCollision(){
        physics.onCollision(manager.checkCollision(this));
    }

    /** for possible future character selection support
    public Player(String characterModel, float modelWidth, float modelHeight, float modelX, float modelY){
        render = new Render(this, characterModel);
        setBounds(modelX, modelY, modelWidth, modelHeight);
    }*/

    public void takeDamage(){
        //this makes the player invincible after taking the initial hit of damage
        if(!takingDamage && !poweredUp){
            score.takeDamage();
        }
        takingDamage=true;
    }

    public Score getScoreObj(){
        return score;
    }

    private int ticks = 0;
    private int powerCount = 0;
    @Override
    public void update() {
        //Gdx.app.log("Untitled", "score: "+score);
        if(takingDamage){
            if(((ticks%2)==0) && !poweredUp){
                render.toggleVisibility();
            }
            ticks++;
            if(ticks==20){
                ticks=0;
                takingDamage=false;
            }
        }
        if(poweredUp){
            manager.modifySpeed(2);
            powerCount++;
            if(powerCount==50){
                //System.out.println("it should be fuggin reseting");
                manager.resetSpeed();
                poweredUp = false;
                powerCount=0;
            }
        }
        physics.tick();
    }

    @Override
    public void onClick()
    {
        physics.Jump(score.getModifier());
    }


}
