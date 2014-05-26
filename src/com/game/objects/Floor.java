package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.game.graphics.Sprite;
import com.game.graphics.Tile;
import com.game.system.CollisionDetection;

public class Floor extends RunnableObject{
	
	Tile floorTile = new Tile(Sprite.bricks, 50, 50);
	int tileCountX;
	int tileCountY;
	
	public Floor() {
		super();
		CollisionDetection.addCollidable(this);
		x = -100;
		y = 460;
		width = 4000;
		height = 50;
		tileCountX = (int)width/floorTile.getWidth();
		if(tileCountX < 1){
			tileCountX = 1;
		}
		tileCountY = (int)height/floorTile.getHeight();
		if(tileCountY < 1){
			tileCountY = 1;
		}

	}
	public Floor(int x, int y, int width, int height){
		super();
		CollisionDetection.addCollidable(this);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		tileCountX = (int) width/floorTile.getWidth();
		if(tileCountX < 1){
			tileCountX = 1;
		}
		tileCountY = (int)height/floorTile.getHeight();
		if(tileCountY < 1){
			tileCountY = 1;
		}
	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		for(int i = 0; i < tileCountY; i++){
			for(int k = 0; k < tileCountX; k++){
				g2d.drawImage(floorTile.getImage(),floorTile.getWidth() *k + (int)x, floorTile.getHeight() * i + (int)y, floorTile.getWidth(), floorTile.getHeight(), null);
			}
		}
	}
	
	public void update() {
		//Nothing here currently. There may never be anything here..		
	}
}

