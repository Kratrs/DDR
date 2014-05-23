package com.game.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class RunnableObject extends Rectangle2D.Double{
	private static final long serialVersionUID = 1L;
	
	static List<RunnableObject> list = new ArrayList<RunnableObject>();
	static Queue<RunnableObject> input = new LinkedList<RunnableObject>(); //This is here as a buffer to prevent concurrent modification exceptions. (Two threads working on the same object).
	static Queue<RunnableObject> output = new LinkedList<RunnableObject>(); //This is here for a removal buffer
	
	public RunnableObject(){
		input.add(this);
	}
	
	public abstract void update();
	public abstract void drawObject(Graphics g);
	
	public static void emptyQueue() {
		while(output.peek() != null)
			list.remove(output.remove());
		while(input.peek() != null)
			list.add(input.remove());
	}
	
	public static void renderObjects(Graphics2D g2d){
		for(RunnableObject o : list){
			o.drawObject(g2d);
		}
	}
	
	public static void updateObjects(){
		for(RunnableObject o : list){
			o.update();
		}
	}

}
