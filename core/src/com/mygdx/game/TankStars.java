package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.screens.MainScreen;

public class TankStars extends Game {
	public SpriteBatch batch;
	public static int WIDTH = 1920;
	public static int HEIGHT = 1080;

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
