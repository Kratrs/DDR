This is the Development Branch.


Todo list:
-- Sound -- Platforms -- Camera(Done. May be improved upon in future) -- Enemies/AI -- User Interface/HUD -- Background -- IMPROVE collision detection(Complete)
--OPTIMIZATION. Game is supposed to run at 60 FPS. But when first loading will drop to ~47. This may occur at other instances as well.\

ChangeLog - 5/26/14:
Map builder now available! There should be a textfile called tileMap in the res folder. When we have more levels we will add more textfiles in there.

ChangeLog - 5/25/14:
FPS now shows in the top left hand corner. Camera class now follows in the Y direction as well. Several test images were added in the res folder and also coded
	into the sprite class.
Background was changed from beach to one of the textures in the sprite class.
When drawing an object it will no longer stretch the texture because it will draw the texture the necessary number of times according to its dimensions.
	Because of this performance has taken a hit. This will need to be optimized in the future or a better solution must be found.

ChangeLog:
Collision detection worked on. CollisionDetection is now possible on all four sides of the character. However, this is still incredibly glitchy.


Change log:
Background image added. This is only a place holder. Also made the floor class invisible so if you're moving down and wondering why you stopped its because of that.
To make it visible again just uncomment it in its' drawObject function.


Change log:
Sprite Class, TimeKeeper Class.
There is now time keeping of the game and there is also now animation for the sprites. The sprites will flip horizontally depending on the direction faced.