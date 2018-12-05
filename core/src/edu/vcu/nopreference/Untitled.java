package edu.vcu.nopreference;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import edu.vcu.nopreference.Screens.*;

public class Untitled extends Game {
	private Screen activeScreen;
	public static Screen newScreen;
	@Override
	public void create () {
		newScreen = new mainMenu();
	}
	@Override
	public void render ()
	{
		if(activeScreen != newScreen)
		{
			setScreen(newScreen);
		}
		super.render();
	}

    @Override
	public void dispose () {
	}

}