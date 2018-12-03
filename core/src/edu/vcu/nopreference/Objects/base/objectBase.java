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
    public boolean toBeDeleted = false; //Set to true to be removed from game.

    //lower draw the number the more background the object
    private int drawOrder = 0;

    public Render render;
    public float posX = 0, posY = 0;
    protected objectBase()
    {
        //Gdx.app.log("Untitled", "New object created");
        initializePhysics();
    }

    public objectBase(int setDrawNum){
        drawOrder=setDrawNum;
        initializePhysics();
    }
    protected void initializePhysics()
    {
        physics = new physicsBase(this);
    }
    objectBase(Render r)
    {

    }
    public void Draw(SpriteBatch batch) {
        render.draw(batch);
    }

    public void onClick(int x, int y)
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

    public void setPosX(float posX_) {
        posX = posX_;
    }
    public void setPosY(float posY_) {
        posY = posY_;
    }
    public void setPosition(float posX_, float posY_) {   // Setter for setting X and Y position at the same time.
        posX = posX_;
        posY = posY_;
    }

    public void updatePosition()//Sets sprites position to local position
    {
        sprite.setPosition(posX, posY);
        if(posX + sprite.getWidth() < -200)
            toBeDeleted = true;
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
