package com.game.system;

import com.game.graphics.Background;
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
    
    public double timer;
    public static double frames;
    public double updates;
    
	public static Boolean running = true;
	
	Screen screen = new Screen(800,500);
	//Background bg = new Background(-500,-500,4000,1200);
	Controls controls = new Controls();
	Flappy flappy = new Flappy(Sprite.player);
	//Floor floor = new Floor();
	//Floor floor2 = new Floor(200,150,200,100);
	//Floor floor3 = new Floor(0,270,50,200);
	//Floor floor4 = new Floor(300,370,150,100);
	//Create a Camera 
	Camera cam = new Camera(0,0);
	
	public void run() {
		
		screen.addKeyListener(controls);
	    currentUpdateTime = System.nanoTime();
	    timer = System.currentTimeMillis();
	    
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
			update();
			updates++;
			render();
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
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = updates;
				updates = 0;
			}
		}		
	}
	
	public void update(){
		System.out.println(CollisionDetection.collidables.size());
		LevelManager.update();
		controls.update();
		RunnableObject.updateObjects();
		TimeKeeper.updateTime();
		cam.update(flappy);
	}
	
	public void render(){
		screen.render();
	}

}
