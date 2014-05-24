package com.game.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.game.graphics.Sprite;
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
		x = 50;
		y = 50;
		width = 100;
		height = 100;
		img = player;
	}
	

	public void update() {		 
		//Falling
		if(CollisionDetection.detectCollision(this))
		{
		  isFalling = false;
		  isJumping = false;
		  velY=0;
		  y = CollisionDetection.getTopBot(this);
		  x = CollisionDetection.getLeftRight(this);
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
		//Screen wrapping
		if(y + height <= 0){
			y = 500;
		}
		else if(y >= 500){
			y = -width;
		}
		
		//Player Controls
		if(Controls.left){
			if(!facingLeft){
				facingLeft = true;
				img = Sprite.flipImage(img);
			}
			x-=playerSpeed;
		}
		else if(Controls.right){
			if(facingLeft){
				facingLeft = false;
				img = Sprite.flipImage(img);
			}
			x+=playerSpeed;
		}
		if(Controls.jump && !isJumping){
			velY-=playerSpeed*3;
			isJumping = true;
		}
	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.fillRoundRect((int)x, (int)y, (int)width, (int)height, 50, 50);
		g2d.drawImage(img.get(currentImage), (int)x, (int)y, (int)width, (int)height,null);
		
	}
	
	public void incrementSprite(){
		if(Controls.left || Controls.right){
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

}
