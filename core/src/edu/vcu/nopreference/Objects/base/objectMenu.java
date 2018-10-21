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
    inputHandler input;
    //constructor of objectMenu
    public objectMenu(inputHandler input){
        super();

        this.input=input;
        render = new Render(this, "pauseMenu.jpg");
        menuVisible = true;
        //anything with sprites ruins unit tests, because libgdx was never designed to be unit tested, so this ugly stuff is what you get
        //until the next iteration when we centralize all sprite manipulation
        if(!Render.testing){sprite.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()- sprite.getHeight());}

    }

    //getter for visibility of menu
    public boolean getVisible(){
        return menuVisible;
    }

    @Override
    public void update() {
    }
    @Override
    protected void initializePhysics() {
        //line of code that prevents object from falling
        GUIAsset=true;
        physics = new physicsGUI(this);
    }

    @Override
    public void onPressed() {
        //if the game is paused, you can interact with the menu
        if(inGame.paused){
            Untitled.newScreen = new mainMenu(input);
            inGame.paused = false;
        }
    }

    //method used for testing, since mainMenu is litered with libgdx code, and since that cant run on unit tests,
    //this method will return a boolean true for if the game is paused, and you click the menu,
    //and a boolean false if the game is not paused and you click the menu. Simulating jump vs go back to main menu.
    public static boolean fakePress(){
        if(inGame.paused){
            return true;
        }
        else{
            return false;
        }
    }
}


