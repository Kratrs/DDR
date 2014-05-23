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
	public static void addCollidable(RunnableObject object){
		collidables.add(object);
	}
}
