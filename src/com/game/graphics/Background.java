package com.game.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.game.graphics.Sprite;
import com.game.graphics.Tile;
import com.game.objects.RunnableObject;

public class Background extends RunnableObject{
	
	Tile tile1 = new Tile(Sprite.tronTexture, 100, 100);
	Tile tile2 = new Tile(Sprite.metalTexture, 256, 256);
	int tileCountX, tileCountY, tileType;
	
	public Background(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		tileCountX = (int) width/tile1.getWidth();
		if(tileCountX < 1){
			tileCountX = 1;
		}
		tileCountY = (int)height/tile1.getHeight();
		if(tileCountY < 1){
			tileCountY = 1;
		}
		tileType = 0;
	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		for(int i = 0; i < tileCountY; i++){
			for(int k = 0; k < tileCountX; k++){
				g2d.drawImage(tile1.getImage(),tile1.getWidth() *k + (int)x, tile1.getHeight() * i + (int)y, tile1.getWidth(), tile1.getHeight(), null);
			}
		}
	}
	
	public void update() {
		//Nothing here currently. There may never be anything here..		
	}
}

