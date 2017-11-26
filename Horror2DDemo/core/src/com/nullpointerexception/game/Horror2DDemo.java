package com.nullpointerexception.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nullpointerexception.screens.MainGameScreen;

public class Horror2DDemo extends Game {
	public SpriteBatch batch;
	Texture img; 
	
	@Override
	public void create () {
		setScreen(new MainGameScreen());
	}

	@Override
	public void render () {
		super.render();  
	} 
	
	@Override
	public void dispose () {
		super.resume();
	}
	
	@Override
	public void pause() {
		super.pause();
	}
	
	@Override
	public void resume() {
		super.resume();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	 
}
