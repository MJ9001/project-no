package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/10/2018.
 */

public class Player extends objectBase {
    boolean takingDamage=false;
    Score score = new Score();

    //default constructor creates player as a default image
    public Player()
    {
        render = new Render(this, "player_temporary_asset.png");
        //sprite.setPosition(0,0);
        setBounds(100, 0, 200, 200);
    }

    //makes it such that the players score decreases by 0.1 every tick
    //this effects the jump height alone currently, but in the future it will effect other factors as well
    @Override
    public void updateCollision(){
        physics.onCollision(manager.checkCollision(this));
    }

    //for possible future character selection support
    public Player(String characterModel, float modelWidth, float modelHeight, float modelX, float modelY){
        render = new Render(this, characterModel);
        setBounds(modelX, modelY, modelWidth, modelHeight);
    }

    public void takeDamage(){
        //this makes the player invincible after taking the initial hit of damage
        if(!takingDamage){
            score.takeDamage();
        }
        takingDamage=true;
    }

    public Score getScoreObj(){
        return score;
    }

    int ticks = 0;
    @Override
    public void update() {
        //Gdx.app.log("Untitled", "score: "+score);
        if(takingDamage){
            if((ticks%2)==0){
                render.toggleVisibility(this);
            }
            ticks++;
            if(ticks==20){
                ticks=0;
                takingDamage=false;
            }
        }
        physics.tick();
    }

    @Override
    public void onClick(int x, int y)
    {
        physics.Jump(score.getModifier());
    }


}
