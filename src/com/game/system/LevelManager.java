package com.game.system;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class LevelManager {
	static ArrayList<TileMap> maps = new ArrayList<TileMap>();
	static TileMap currentMap;
	
	TileMap level1 = new TileMap("res/tileMap");
	
	public void load(){
		level1.getTileMap();
		maps.add(level1);
		currentMap = maps.get(0);
		currentMap.loadMap();
	}
	
	public static void update(){
		currentMap = maps.get(0);
	}
	
	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		currentMap.drawMap(g2d);
	}

}
