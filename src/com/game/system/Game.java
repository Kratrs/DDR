package com.game.system;

import com.game.graphics.Screen;
import com.game.objects.Flappy;
import com.game.objects.Floor;
import com.game.objects.RunnableObject;

public class Game implements Runnable{
	
	long targetFPS = 60;
	long targetDeltaLoop = 1000000000/targetFPS;
	long beginLoopTime;
    long endLoopTime;
    long currentUpdateTime = System.nanoTime();
    long lastUpdateTime;
    long deltaLoop;
    
	private Boolean running = true;
	
	Screen screen = new Screen(800,500);
	Controls controls = new Controls();
	Flappy flappy = new Flappy();
	Floor floor = new Floor();
	
	public void run() {
		screen.addKeyListener(controls);
	    currentUpdateTime = System.nanoTime();
	    
		while(running){
			//System.out.println(CollisionDetection.collidables);
			beginLoopTime = System.nanoTime();
			RunnableObject.emptyQueue();
			lastUpdateTime = currentUpdateTime;
			currentUpdateTime = System.nanoTime();
			controls.update();
			RunnableObject.updateObjects();
			screen.render();
			endLoopTime = System.nanoTime();
			
			deltaLoop = endLoopTime - beginLoopTime;
			
			if(deltaLoop > targetDeltaLoop){
	
			}
			else{
				try{
					Thread.sleep((targetDeltaLoop - deltaLoop)/1000000);
				}catch(InterruptedException e){
					
				}
			}

		}		
	}

}
