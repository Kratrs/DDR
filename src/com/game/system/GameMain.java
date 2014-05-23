package com.game.system;

import com.game.graphics.Sprite;


public class GameMain {

	public static void main(String[] args) {
		new Sprite().load();
		Game g = new Game();
		new Thread(g).start();

	}

}
