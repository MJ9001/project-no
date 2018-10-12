package edu.vcu.nopreference;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.menu;

public class Untitled extends Game {
	Screen game;
	@Override
	public void create () {
		game = new menu();
		this.setScreen(game);
	}
	@Override
	public void render ()
	{
		super.render();
	}

	@Override
	public void dispose () {
	}
}