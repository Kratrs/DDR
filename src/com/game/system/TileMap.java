package com.game.system;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.game.graphics.Sprite;
import com.game.objects.Floor;

public class TileMap {
	
	StringBuilder sb = new StringBuilder();
	String resPath;
	
	int tileWidth = 100;
	int tileHeight = 100;
	
	int startingHeight = -13;
	
	public TileMap(String path){
		resPath = path;
	}
	
	public void getTileMap(){
		Scanner scan = null;
		try{
			scan = new Scanner(new FileReader(resPath));
		}catch(FileNotFoundException e){
			System.out.println("ERROR!");
			e.printStackTrace();
		}
		while(scan.hasNextLine()){
			sb.append(scan.nextLine());
		}
	}
	
	public void loadMap(){
		int j = 0;
		int k = startingHeight;
		for(int i = 0; i < sb.length(); i++){
			String curChar = "" + sb.charAt(i);
			if(curChar.equals("0")){
				//Background goes here
				j++;
			}
			else if(curChar.equals("1")){
				//Floor and walls here
				new Floor(tileWidth * j, tileHeight * k, tileWidth, tileHeight);
				j++;
			}
			else if(curChar.equals("2")){
				//System.out.println("New line activator here");
				k++;
				j = 0;
			}
			else if(curChar.equals("3")){
				//System.out.println("End of the map activator here");
				break;
			}
		}
	}
	public void drawMap(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		int j = 0;
		int k = startingHeight;
		for(int i = 0; i < sb.length(); i++){
			String curChar = "" + sb.charAt(i);
			if(curChar.equals("0")){
				//Background goes here
				g2d.drawImage(Sprite.tronTexture, tileWidth * j, tileHeight * k, tileWidth, tileHeight, null);
				j++;
			}
			else if(curChar.equals("1")){
				//Floor and walls here
				g2d.drawImage(Sprite.bricks, tileWidth * j, tileHeight * k, tileWidth, tileHeight, null);
				j++;
			}
			else if(curChar.equals("2")){
				//System.out.println("New line activator here");
				k++;
				j = 0;
			}
			else if(curChar.equals("3")){
				//System.out.println("End of the map activator here");
				break;
			}
		}
	}
	
	public String getTextMap(){
		String finalString = "";
		for(int i = 0; i < sb.length(); i++){
			String curChar = "" + sb.charAt(i);
			if(curChar.equals("0")){
				//System.out.println("Background here");
				finalString += curChar;
			}
			else if(curChar.equals("1")){
				//System.out.println("Floor and walls here");
				finalString += curChar;
			}
			else if(curChar.equals("2")){
				//System.out.println("New line activator here");
				finalString += "\n";
			}
			else if(curChar.equals("3")){
				//System.out.println("End of the map activator here");
			}
		}
		return finalString;
	}
}
