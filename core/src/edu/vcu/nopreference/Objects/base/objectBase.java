package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Objects.physics.physicsBase;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/8/2018.
 */

public class objectBase {
    public Sprite sprite = new Sprite();
    public objectManager manager;
    public physicsBase physics;
    public boolean visible=true;
    public boolean GUIAsset=false;
    protected boolean toBeDeleted = false; //Set to true to be removed from game.
    //variables used to set initial speed
    public static float speedModifier;//MUST SET IN objectManager.initializeObjects() OTHERWISE PROGRAM BREAKS
    public float speedValue=(50f * speedModifier);
    protected float originalSpeed=50f;

    //lower draw the number the more background the object
    private int drawOrder = 0;

    public Render render;
    public float posX = 0, posY = 0;
    protected objectBase()
    {
        //Gdx.app.log("Untitled", "New object created");
        initializePhysics();
    }

    protected void initializePhysics()
    {
        physics = new physicsBase(this);
    }

    public void Draw(SpriteBatch batch) {
        render.draw(batch);
    }

    public void onClick()
    {

    }
    public void onPressed()
    {

    }
    public void update() //Called every tick
    {
        physics.tick();
        //posX+= 0.01f;
        //updatePosition();
    }

    public void updatePosition()//Sets sprites position to local position
    {
        sprite.setPosition(posX, posY);
        if(posX + sprite.getWidth() < -200)
            toBeDeleted = true;
    }

    public void updateSpeed(float modifier){
        speedValue = originalSpeed * modifier;
        speedModifier = modifier;
    }

    public void resetSpeed(){
        speedValue = originalSpeed;
        speedModifier = 1f;
    }

    public void updateCollision()//Check collision
    {
        physics.onCollision(manager.checkCollision(this));
    }

    protected void setBounds(float x, float y, float width, float height)
    {
        posX = x;
        posY = y;
        sprite.setBounds(x, y, width, height);
    }

    //method used to set drawOrder, which is then used by object manager to
    public void setDrawOrder(int drawNum){
        drawOrder=drawNum;
    }

    public int getDrawOrder(){
        return drawOrder;
    }

    public void receiveIntent(String Intent, String args)
    {
    }

    public String requestIntent(String request) {
        return null;
    }
}
