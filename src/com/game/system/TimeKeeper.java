package com.game.system;

public class TimeKeeper {
	public static double systemTime = System.nanoTime();
	public static double currentTime = systemTime;
	private static double gameTime = 0;
	
	public static void updateTime(){
		systemTime = System.nanoTime();
		if(systemTime - currentTime > 1){
			currentTime = systemTime;
			gameTime += 0.01;
		}
	}
	
	public static double getTime(){
		return gameTime;
	}
}
