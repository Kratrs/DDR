package com.game.system;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import com.game.objects.Flappy;
import com.game.objects.RunnableObject;

public class CollisionDetection {
	static List<RunnableObject> collidables = new ArrayList<RunnableObject>();

	public static boolean checkBot(Rectangle2D.Double r) {
		for (RunnableObject o : collidables) {
			if (o != r) {
				if (((Flappy) r).getLowBounds().intersects(o)) return true;
			}
		}
		return false;
	}

	public static double getBot(Rectangle2D.Double r) {
		for (RunnableObject o : collidables) {
			if (o != r) {
				((Flappy) r).getLowBounds();
				if (((Flappy) r).getLowBounds().intersects(o)) {
					return o.y - r.height;
				}
			}
		}
		return r.y;
	}

	public static double getTop(Rectangle2D.Double r) {
		for (RunnableObject o : collidables) {
			if (o != r) {
				if (((Flappy) r).getTopBounds().intersects(o)) {
					((Flappy) r).setvelY(0);
					return o.y + r.height;
				}
			}
		}
		return r.y;
	}

	public static double getLeft(Rectangle2D.Double r) {
		for (RunnableObject o : collidables) {
			if (o != r) {
				if (((Flappy) r).getLeftBounds().intersects(o))
					r.x =r.x + 5;
				

			}

		}

		return r.x;
	}

	public static double getRight(Rectangle2D.Double r) {
		for (RunnableObject o : collidables) {
			if (o != r) {
				if (((Flappy) r).getRightBounds().intersects(o))
					r.x =r.x - 5;
			}

		}

		return r.x;
	}

	public static void addCollidable(RunnableObject object) {
		collidables.add(object);
	}
}
