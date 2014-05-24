package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.game.graphics.Sprite;
import com.game.system.CollisionDetection;

public class Floor extends RunnableObject{
	
	public Floor() {
		super();
		CollisionDetection.addCollidable(this);
		x = -100;
		y = 390;
		width = 4000;
		height = 20;

	}
	public Floor(int x, int y, int width, int height){
		super();
		CollisionDetection.addCollidable(this);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.drawImage(Sprite.bricks,(int) x, (int) y, (int)width, (int)height, null);
	
	}


	public void update() {
		// TODO Auto-generated method stub
		
	}
}

