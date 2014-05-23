package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import com.game.graphics.Sprite;
import com.game.system.CollisionDetection;
import com.game.system.Controls;
import com.game.system.Game;

public class Flappy extends RunnableObject{
	private static final long serialVersionUID = 1L;
	private int playerSpeed = 5;

	BufferedImage img;
	Sprite sprite;
	
	public Flappy(){
		CollisionDetection.addCollidable(this);
		x = 50;
		y = 50;
		width = 50;
		height = 50;
		try {
			img =  ImageIO.read(new File("res/Player1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public void update() {
		System.out.println(CollisionDetection.detectCollision(this));
		//Player Controls
		if(Controls.left){
			x-=playerSpeed;
		}
		else if(Controls.right){
			x+=playerSpeed;
		}
		if(Controls.up){
			y-=playerSpeed;
		}
		else if(Controls.down && !CollisionDetection.detectCollision(this)){
			y+=playerSpeed;
		}
		if(Controls.jump){
			
		}
		//Screen wrapping
		if(y + height <= 0){
			y = 500;
		}
		else if(y >= 500){
			y = -width;
		}
		if(x + width <= 0){
			x = 800;
		}
		else if(x >= 800){
			x = -height;
		}

		//System.out.println("Left: " + Controls.left + " Right: " + Controls.right + " Down: " + Controls.down + " Up: " + Controls.up + " Jump: " + Controls.jump);

	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.YELLOW);
		//g2d.fillRoundRect((int)x, (int)y, (int)width, (int)height, 20, 20);
		g2d.drawImage(img, (int)x, (int)y, (int)width, (int)height,null);
		
	}

}
