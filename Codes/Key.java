package deneme;

/**
 * 
 * Author: Semih Teker
 * 
 */

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Key extends Bonus {

	Vector2f position;
	//Vector2f dimension;
	float duration;
	float remainingTime;
	Image img = new Image("res/key.png");
	Icon keyIcon;
	
	public Key(Vector2f position) throws SlickException {
		this.position=position;
		//this.dimension=dimension;
		//img = new Image("res/key.png");
		keyIcon = new Icon(position, img);
		super.shape = new Rectangle(position.x, position.y, img.getWidth(), img.getHeight());
	}
	
	public Key(Vector2f position, float duration, float remainingTime) throws SlickException {
		this.position=position;
		//this.dimension=dimension;
		//img = new Image("res/key.png");
		this.duration = duration;
		this.remainingTime = remainingTime;
		keyIcon = new Icon(position, img);
		super.shape = new Rectangle(position.x, position.y, img.getWidth(), img.getHeight());
	}
	
	public void setPosition(Vector2f pos) {
		this.position = pos;		
	}

	public boolean collect(){
		return pickedUp;	
	}
	
	@Override
	public void draw(Graphics g) {
		if(!pickedUp){
			keyIcon.draw(g);
		}	
	}
	
	@Override
	public void update(){
		if(pickedUp){
			this.setToBeRemoved(true);
		}
		keyIcon.update();
		if(remainingTime > 0){
			remainingTime--;
		}
		else{
			this.setToBeRemoved(true);
			if(remainingTime <= duration){
				remainingTime++;
			}
		}
	}

}