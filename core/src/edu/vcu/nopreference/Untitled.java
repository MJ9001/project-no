package edu.vcu.nopreference;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import edu.vcu.nopreference.Screens.*;

public class Untitled extends Game {
	public static Screen newScreen;
	@Override
	public void create () {
		newScreen = new mainMenu();
	}
	@Override
	public void render ()
	{
		setScreen(newScreen);
		super.render();
	}

    @Override
	public void dispose () {
	}

}