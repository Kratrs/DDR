package com.game.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.game.graphics.Sprite;
import com.game.graphics.Tile;
import com.game.objects.RunnableObject;

public class Background extends RunnableObject{
	
	Tile tile = new Tile(Sprite.tronTexture, 256, 256);
	int tileCountX, tileCountY;
	
	public Background(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		tileCountX = (int) width/tile.getWidth();
		if(tileCountX < 1){
			tileCountX = 1;
		}
		tileCountY = (int)height/tile.getHeight();
		if(tileCountY < 1){
			tileCountY = 1;
		}
	}

	public void drawObject(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		for(int i = 0; i < tileCountY; i++){
			for(int k = 0; k < tileCountX; k++){
				g2d.drawImage(tile.getImage(),tile.getWidth() *k + (int)x, tile.getHeight() * i + (int)y, tile.getWidth(), tile.getHeight(), null);
			}
		}
	}
	
	public void update() {
		//Nothing here currently. There may never be anything here..		
	}
}

