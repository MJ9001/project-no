package edu.vcu.nopreference;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.vcu.nopreference.Screens.inGame;

public class Untitled extends Game {
	inGame game;
	@Override
	public void create () {
		game = new inGame();
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