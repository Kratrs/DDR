package com.game.system;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import com.game.objects.RunnableObject;

public class CollisionDetection {
	static List<RunnableObject> collidables = new ArrayList<RunnableObject>();
	
	public static boolean detectCollision(Rectangle2D.Double r){
		for(RunnableObject o : collidables){
			if(o != r){
				if(r.intersects(o))
					return true;
			}
		}
		return false;
	}
	
	public static double getTopBot(Rectangle2D.Double r){
		for(RunnableObject o : collidables){
			if(o != r){
				if(r.intersects(o)){
					if(r.y < o.y)
						return o.y - r.height;
					else if(r.y > o.y)
						return o.y;
				}
			}
		}
		return r.y;
	}
	public static double getLeftRight(Rectangle2D.Double r){
		for(RunnableObject o : collidables){
			if(o != r){
				if(r.intersects(o)){
					if(r.x < o.x)
						return o.x-r.width;
					else if(r.x > o.x)
						return o.x+o.width;
				}
			}
		}
		return r.x;
	}
	public static void addCollidable(RunnableObject object){
		collidables.add(object);
	}
}
