package com.nullpointerexception.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.nullpointerexception.game.Horror2DDemo;

public class MainMenuScreen implements Screen {

	private Horror2DDemo game;
	Texture resumeButton;
	Texture pressedResume;
	Texture exitButton;
	Texture pressedExit;
	Texture FAQ;
	Texture pressedFAQ;
	
	public MainMenuScreen(Horror2DDemo game) {
		this.game = game;
	//	resumeButton = new Texture("")
	//	pressedResume = new Texture("")
	//	exitButton = new Texture("")
	//	pressedExit = new Texture("")
	//	FAQ = new Texture("")
	//	pressedFAQ = new Texture("")
	}

	@Override
	public void show() {	
	}

	@Override
	public void render(float delta) {	
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {	
	}

	@Override
	public void pause() {	
	}

	@Override
	public void resume() {	
	}

	@Override
	public void hide() {	
	}

	@Override
	public void dispose() {	
	}

}
