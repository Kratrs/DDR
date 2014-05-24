package com.game.system;

import com.game.graphics.Screen;
import com.game.graphics.Sprite;
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
    
	public static Boolean running = true;
	
	Screen screen = new Screen(800,500);
	Controls controls = new Controls();
	Flappy flappy = new Flappy(Sprite.player);
	Floor floor = new Floor();
	Floor floor2 = new Floor(200,100,200,100);
	Floor floor3 = new Floor(0,200,50,200);
	Floor floor4 = new Floor(300,300,150,100);
	//Create a Camera 
	Camera cam = new Camera(0,0);
	
	public void run() {
		screen.addKeyListener(controls);
	    currentUpdateTime = System.nanoTime();
	    
		while(running){
			if(Controls.quit)
			{
				System.exit(1);
			}
			//System.out.println(TimeKeeper.systemTime + "   " + TimeKeeper.currentTime);
			beginLoopTime = System.nanoTime();
			RunnableObject.emptyQueue();
			lastUpdateTime = currentUpdateTime;
			currentUpdateTime = System.nanoTime();
			controls.update();
			RunnableObject.updateObjects();
			TimeKeeper.updateTime();
			//added Camera 
			cam.update(flappy);
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
