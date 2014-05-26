package com.game.graphics;

import java.awt.image.BufferedImage;

public class Tile {
	BufferedImage tileType;
	int tileWidth, tileHeight;
	
	public Tile(BufferedImage tile, int tileWidth, int tileHeight){
		
		tileType = tile;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		
	}
	
	public int getWidth(){
		return tileWidth;
	}
	
	public int getHeight(){
		return tileHeight;
	}
	
	public BufferedImage getImage(){
		return tileType;
	}

}
