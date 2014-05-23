package com.game.system;


public class GameMain {

	public static void main(String[] args) {
		Game g = new Game();
		new Thread(g).start();

	}

}
