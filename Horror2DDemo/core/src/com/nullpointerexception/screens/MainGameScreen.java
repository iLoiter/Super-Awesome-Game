package com.nullpointerexception.screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.nullpointerexception.entities.Survivor;




public class MainGameScreen implements Screen {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Survivor survivor;
	private TextureAtlas survivorAtlas;
	@Override
	
	
	
	public void show() {
		map = new TmxMapLoader().load("maps/2DHaddonfield.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		survivorAtlas = new TextureAtlas("character/player1sheet/survivor1sheet.pack");
		survivor = new Survivor(new Sprite(new Texture("character/player1/down1.png")), (TiledMapTileLayer) map.getLayers().get(0));
		survivor.setPosition(100,100);
		Animation<AtlasRegion> up, down, left, right;
		up = new Animation<AtlasRegion>(1/6f, survivorAtlas.findRegion("up"));
		down = new Animation<AtlasRegion>(1/6f, survivorAtlas.findRegion("down"));
		left = new Animation<AtlasRegion>(1/6f, survivorAtlas.findRegion("left"));
		right = new Animation<AtlasRegion>(1/6f, survivorAtlas.findRegion("right"));
	
	//	survivor = new Survivor(up, down , left, right, (TiledMapTileLayer) map.getLayers().get(0));
		Gdx.input.setInputProcessor(survivor);
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.position.set(MathUtils.ceil(2.5f*survivor.getX() + survivor.getWidth() / 2)/2.5f,
				MathUtils.ceil(2.5f*survivor.getY() + survivor.getHeight() / 2)/2.5f, 0);
		camera.update();
		
		renderer.setView(camera);
		renderer.getBatch().begin();
		
		renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get("GroundLayer"));
		
		survivor.draw(renderer.getBatch());
		renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get("ForegroundLayer"));
		renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get("BlockLayer"));
		renderer.getBatch().end();
		
	}
	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		
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
		map.dispose();
		renderer.dispose();
		survivor.getTexture().dispose();
		survivorAtlas.dispose();
	}
}

