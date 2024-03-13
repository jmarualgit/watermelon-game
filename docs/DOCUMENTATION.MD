## 0.0 
### 2024-03-09
### Commit #1-2 (4-5)
Setting up the start of my first game! I will base it off of [RyiSnow's basic 2D Java Game tutorial](https://youtube.com/playlist?list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq&si=SIBaFGlA1kHp2_1q) with some tweaks. This first commit will just be of the basic window and a game loop. As can be seen in future commits, one of the biggest changes I'll make to the tutorial is practicing encapsulation. Along with the first commits will be all the textures I so far have made which includes grass, stone, tree, water, and a left&right version of the main character. I chose to do pixel art as I have little to no artistic talent and pixel art has an arguably smaller starting learning curve.

For the most part, I have the timer set up the same way as RyiSnow, with the sleep method. I could not find a way that would make me understand it more or a way that I personally saw fit. I am a beginner after all.

Commits 4 and 5 relate to documentation file errors and submitting the wrong file.

### Commit #3
Not having a reason to manually set the values of upPressed, downPressed, etc. is another reason as to hide them and practice more encapsulation. I set up getters instead of having the variables public.

### Commit #7
In Player.java, getImage() and setStartingValues() have been set to private instead there is no reason that any other class in the project needs access to it. The same was made about all entity's xpos, ypos, and speed. I also made the speed of the player as variable affected by the game's FPS. I plan to incorporate scalability in the future to help with whenever the game's settings are changed. It will also be a possibility to have a speed as a function of game difficulty.

### Commit #8
#### Tile Manager
In contrast to RyiSnow's tutorial, I added a lot more clarifying variables for my own personal comprehension and so that it was easier for me personally to look at. tileToDraw in the drawWorld() function is extra and wasn't in the tutorial. I have yet to implement the camera function so this commit will just have the top left of the world as the top left is (0,0). I will also implement RyiSnow's method of having the center of (25, 25) (in terms of world01.txt) in probably the next commit.