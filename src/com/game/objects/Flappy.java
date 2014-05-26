package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.game.graphics.Sprite;
import com.game.system.Camera;
import com.game.system.CollisionDetection;
import com.game.system.Controls;
import com.game.system.TimeKeeper;

public class Flappy extends RunnableObject{
	private static final long serialVersionUID = 1L;
	private int playerSpeed = 5;
	private int currentImage = 0;
	private boolean imageBack = false;
	private boolean facingLeft = false;
	private double lastTime = 0;
	
	private int gravity = 1;
	private int maxGravity = 60;
	private boolean isFalling = true;
	private boolean isJumping = false;
	private double velY = 0;

	ArrayList<BufferedImage> img;
	
	public Flappy(ArrayList<BufferedImage> player){
		CollisionDetection.addCollidable(this);
		x = 200;
		y = 50;
		width = 100;
		height = 100;
		img = player;
	}
	

	public void update() {	
		//Falling
		if(CollisionDetection.checkBot(this))
		{
		  isFalling = false;
		  isJumping = false;
		  velY=0;
		  y = CollisionDetection.getBot(this);
		}
		else{
			isFalling = true;
		}
		if((isFalling || isJumping))
		{
			if(velY <= maxGravity){
				velY += gravity;
			}
		}
		y +=velY;
		incrementSprite();
		
		//Player Controls
		if(Controls.left){
			if(!facingLeft){
				facingLeft = true;
				img = Sprite.flipImage(img);
			}
			x-=playerSpeed;
			x = CollisionDetection.getLeft(this);
		}
		else if(Controls.right){
			if(facingLeft){
				facingLeft = false;
				img = Sprite.flipImage(img);
			}
			x+=playerSpeed;
			x = CollisionDetection.getRight(this);
		}
		if(Controls.jump && !isJumping){
			velY-=playerSpeed*4;
			isJumping = true;
		}
		y = CollisionDetection.getTop(this);
	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//g2d.fillRoundRect((int)x, (int)y, (int)width, (int)height, 50, 50);
		g2d.drawImage(img.get(currentImage), (int)x, (int)y, (int)width, (int)height,null);
		//g2d.setColor(Color.red);
		//g2d.draw(getLowBounds());
		//g2d.draw(getTopBounds());
		//g2d.draw(getLeftBounds());
		//g2d.draw(getRightBounds());
	}
	
	public void incrementSprite(){
		if((Controls.left || Controls.right) && !isJumping){
			if(TimeKeeper.getTime() - lastTime > 0.04){
				lastTime = TimeKeeper.getTime();
				if(currentImage < 8 && !imageBack){
					currentImage++;
				}
				else if(currentImage >=8){
					imageBack = true;
					currentImage--;
				}
				else{
					currentImage--;
					if(currentImage <= 6){
						imageBack = false;
						currentImage = 0;
					}
				}
	
			}
		}
		else{
			currentImage = 0;
		}
	}
	public double setvelY(){
		return velY;
	}
	

	public void setvelY(double velY) {
		this.velY = velY;
	}
	public Rectangle getLowBounds(){
		return new Rectangle((int)x + 35, (int)y + 88, (int)width/3, (int)height/8);
	}
	public Rectangle getTopBounds(){
		return new Rectangle((int)x + 35, (int)y, (int)width/3, (int)height/8);
	}
	public Rectangle getLeftBounds(){
		return new Rectangle((int)x + 20, (int)y+5, (int)width/8, (int)height- 12);	
	}
	public Rectangle getRightBounds(){
		return new Rectangle((int)x + 70, (int)y+5, (int)width/8, (int)height- 12);	
	}
}
