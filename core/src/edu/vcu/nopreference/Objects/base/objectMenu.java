package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;
import edu.vcu.nopreference.Untitled;

/**
 * Created by Mark on 10/14/2018.
 */

public class objectMenu extends objectBase {
    boolean menuVisible = false;
    boolean backToMain = false;
    public objectMenu(){
        super();
        render = new Render(this, "pauseMenu.jpg");
        menuVisible = true;
        //anything with sprites ruins unit tests, because libgdx was never designed to be unit tested, so this ugly stuff is what you get
        //until the next iteration when we centralize all sprite manipulation
        if(!Render.testing){sprite.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()- sprite.getHeight());}

    }

    public boolean getVisible(){
        return menuVisible;
    }

    @Override
    public void update() {
    }
    @Override
    protected void initializePhysics()
    {
        physics = new physicsGUI(this);
    }
    @Override
    public void onPressed()
    {
        if(inGame.paused){
            Untitled.newScreen = new mainMenu();
            //backToMain = true;
        }
        else{
            physics.Jump();
        }
    }

   public void fakeOnPress(){
        backToMain = true;
        Untitled.newScreen = new mainMenu();

    }


     public boolean returnToMain(){
        return backToMain;
    }

}


