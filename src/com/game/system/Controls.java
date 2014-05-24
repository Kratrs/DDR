package com.game.system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener{
	private boolean keys[] = new boolean[256];
	public static boolean left,right,down,up,jump, quit;
	
	public void update(){
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		jump = keys[KeyEvent.VK_SPACE];
		quit = keys[KeyEvent.VK_ESCAPE];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;	
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

}