package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class inputHandler {
    objectManager objectman;
    public void inputHandler(){

    }
    public void inputHandler(objectManager objectman){
        this.objectman = objectman;
    }

    public void inputHandling(){
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                objectman.onClick(screenX, screenY);
                Gdx.app.log("Untitled", "inputX: " + screenX + "inputY: " + screenY);
                return true;
            }

        });
    }

    public void updateObjectManager(objectManager objectman){
        Gdx.app.log("Untitled", "Updating objectmanager");
        this.objectman = objectman;
    }
}
