package com.game.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.game.objects.RunnableObject;
import com.game.system.Camera;


public class Screen extends Canvas{
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame();
	BufferStrategy bufferStrategy;
	
	public Screen(int width, int height){
		setBounds(0,0,width,height);
		setIgnoreRepaint(true);
		
		frame.add(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.requestFocus();
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		createBufferStrategy(3);
		bufferStrategy = getBufferStrategy();
		
		requestFocus();
	}
	
	public void render(){
		Graphics2D g2d = (Graphics2D)bufferStrategy.getDrawGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0,getWidth(),getHeight());
		g2d.translate(Camera.getX(), Camera.getY());//begin of cam
		g2d.drawImage(Sprite.test, -Sprite.test.getWidth()/2, 0, Sprite.test.getWidth()*2, Sprite.test.getHeight(), null);
		RunnableObject.renderObjects(g2d);
		g2d.dispose();
		bufferStrategy.show();

	}
	
}
