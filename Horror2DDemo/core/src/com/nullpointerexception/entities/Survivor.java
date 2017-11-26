package com.nullpointerexception.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

public class Survivor extends Sprite implements InputProcessor {
	private Animation up, down, left, right;
	private Vector2 velocity = new Vector2();
	private float animationTime = 0;
	private float speed = 200f;
	private String blockedKey = "Blocked";
	private TiledMapTileLayer collisionLayer;
	//public Survivor(Animation up, Animation down, Animation left, Animation right, TiledMapTileLayer collisionLayer) {
	//	this.up = up;
	//	this.down = down;
	//	this.left = left;
	//	this.right = right;
	public Survivor(Sprite sprite, TiledMapTileLayer collisionLayer) {
		super(sprite);
		this.collisionLayer = collisionLayer;
	}
	
	@Override
	public void draw(Batch batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}

	public void update(float deltaTime) {
		//velocity.y-=gravity*delta;
        if(velocity.y>speed)velocity.y=speed;
        else if (velocity.y<-speed)velocity.y=-speed;
    	// save old position
		float oldX = getX(), oldY = getY();
	
		boolean collisionX = false, collisionY = false;
		// move on x
		setX(getX() + velocity.x * deltaTime * 2f);

		if(velocity.x < 0) // going left
			collisionX = collidesLeft();
		else if(velocity.x > 0) // going right
			collisionX = collidesRight();
		// react to x collision
		if(collisionX) {
			setX(oldX);
			velocity.x = 0;
		}
		// move on y
		setY(getY() + velocity.y * deltaTime * 2f);

		if(velocity.y < 0) // going down
			collisionY = collidesBottom();
		else if(velocity.y > 0) // going up
			collisionY = collidesTop();
		// react to y collision
		if(collisionY) {
			setY(oldY);
			velocity.y = 0;
		}
		animationTime += deltaTime;
	//	setRegion(velocity.x < 0 ? left.getKeyFrame(animationTime) : velocity.x > 0 ? right.getKeyFrame(animationTime));
				System.out.println("x: " + velocity.x + " y: " + velocity.y);
	}

	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Keys.W:
			velocity.y = speed;
			break;
		case Keys.A:
			velocity.x = -speed;
			break;
		case Keys.S:
			velocity.y = -speed;
			break;
		case Keys.D:
			velocity.x = speed;
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Keys.A:
		velocity.x = 0;
		break;
	}
	switch(keycode) {
		case Keys.D:
		velocity.x = 0;
		break;
	}
	switch(keycode) {
		case Keys.W:
		velocity.y = 0;
		break;
	}
	switch(keycode) {
		case Keys.S:
		velocity.y = 0;
		break;
	}
	return true;
}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}
	
	private boolean isCellBlocked(float x, float y) {
		Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
	}
public boolean collidesRight() {
	for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
		if(isCellBlocked(getX() + getWidth(), getY() + step))
			return true;
	return false;
}

public boolean collidesLeft() {
	for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
		if(isCellBlocked(getX(), getY() + step))
			return true;
	return false;
}

public boolean collidesTop() {
	for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
		if(isCellBlocked(getX() + step, getY() + getHeight()))
			return true;
	return false;
}

public boolean collidesBottom() {
	for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
		if(isCellBlocked(getX() + step, getY()))
			return true;
	return false;
	}

public Vector2 getVelocity() {
	return velocity;
}

public void setVelocity(Vector2 velocity) {
	this.velocity = velocity;
}

public float getSpeed() {
	return speed;
}

public void setSpeed(float speed) {
	this.speed = speed;
}

public TiledMapTileLayer getCollisionLayer() {
	return collisionLayer;
}

public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
	this.collisionLayer = collisionLayer;
}

}
