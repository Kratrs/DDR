package com.game.system;

import com.game.objects.Flappy;

public class Camera {
	private static float x;
	private static float y;

	public Camera(float x, float y) {
		Camera.x = x;
		Camera.y = y;
	}

	public void update(Flappy flappy){
		x = (float) (-flappy.getX() + 380);
		
	}
	
	public static float getX() {
		return x;
	}

	public void setX(float x) {
		Camera.x = x;
	}
	
	public static float getY() {
		return y;
	}

	public void setY(float y) {
		Camera.y = y;
	}

}
