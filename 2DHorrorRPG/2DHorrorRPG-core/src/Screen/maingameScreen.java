package Screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import entities.Player;



public class maingameScreen implements Screen {
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Player player;
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();
		
		renderer.getBatch().begin();
		player.draw(renderer.getBatch());
		renderer.getBatch().end();
	}
	@Override
	public void show() {
		
		map = new TmxMapLoader().load("maps/2DHaddonfield.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		player = new Player(new Sprite(new Texture("characters/Mega.jpg")));
	//	player.setPosition(20 * player.getCollisionLayer().getTileWidth(), 25* player.getCollisionLayer().getTileHeight());
		
	}
	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
	}
	@Override
	public void pause() {
	}
	@Override
	public void resume() {

	}
	@Override
	public void hide() {
		dispose();
	}
	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		player.getTexture().dispose();
	}

}
