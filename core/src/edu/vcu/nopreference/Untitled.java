package edu.vcu.nopreference;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
		//setScreen(new inGame());
		super.render();
	}
	public void setActiveScreen(Screen screen)
	{
		Gdx.app.log("Untitled", "Setting screen to " + newScreen.toString());
		//activeScreen.hide();
		activeScreen = newScreen;
		this.setScreen(newScreen);
	}

	@Override
	public void dispose () {
	}
}