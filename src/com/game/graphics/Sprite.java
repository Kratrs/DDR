package com.game.graphics;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Sprite {
	
	public static ArrayList<BufferedImage> player;
	public static BufferedImage playerSheet;
	public static BufferedImage background;
	public static BufferedImage test;
	public static BufferedImage test2;
	public static BufferedImage bricks;
	public static BufferedImage metalTexture;
	public static BufferedImage tronTexture;
	
	public void load(){
		playerSheet = loadSprite("res/PlayerAdjusted2.png");
		player = createSprite(playerSheet, 9, (playerSheet.getWidth()/9), playerSheet.getHeight()-1);
		background = loadSprite("res/ocean.png");
		test = loadSprite("res/test.png");
		test2 = loadSprite("res/test2.png");
		bricks = loadSprite("res/bricks.png");
		metalTexture = loadSprite("res/metalTexture.jpg");
		tronTexture = loadSprite("res/tron.jpg");
	}
		
	public BufferedImage loadSprite(String path){
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BufferedImage> createSprite(BufferedImage img, int spriteCount, int width, int height){
		ArrayList<BufferedImage> sprite = new ArrayList<BufferedImage>();
		for(int i = 0; i < spriteCount; i++){
			sprite.add(cropImage(img,i * width, 1, width, height));
		}
		return sprite;
	}
	
	public BufferedImage cropImage(BufferedImage ig, int x, int y, int width, int height){
		return ig.getSubimage(x, y, width, height);
	}
	
	public static ArrayList<BufferedImage> flipImage(ArrayList<BufferedImage> img){		
		ArrayList<BufferedImage> out = new ArrayList<BufferedImage>();
		for(BufferedImage i:img){
			AffineTransform trans1 = AffineTransform.getScaleInstance(-1, 1);			
			trans1.translate(-i.getWidth(), 0);										
			AffineTransformOp trans2 = new AffineTransformOp(trans1, null);
			out.add(trans2.filter(i, null));		
		}
		return out;
	}
}


