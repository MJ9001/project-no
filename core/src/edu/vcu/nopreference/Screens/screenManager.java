package edu.vcu.nopreference.Screens;

import com.badlogic.gdx.Screen;

import java.util.List;

/**
 * Created by Mark on 10/12/2018.
 */

public class screenManager {
    List<Screen> screens;
    screenManager()
    {
        screens.add(new inGame());
    }
    public void renderScreens()
    {

    }
}
