# **'Untitled'** by **Team No**.

## Iteration One:
### As a player in game, I want to be able to tap the screen to jump onto platforms, so that I can reach objectives and avoid obstacles.
a) Given that I am in game moving towards a platform, when I tap the screen, then I should move upwards and then fall towards a platform, and when it looks like I should fall to rest on a platform, then I should land on that platform.

b) Given that I am in game moving towards a platform, when I tap the screen, then I should move upwards and then fall towards a platform, and when it looks like I shouldn’t fall to rest on a platform, then I should fall back to the ground.

c) Given that I am in game and a platform is above me, when I tap the screen, then I should move upwards and will land on the platform

### As a player, I want to be able to quickly pause the game while playing to quit.
a) Given that I am in-game, when I press the pause button, a menu should prompt the user to change settings or quit the game and return to the main menu.

b) Given that I am in game, when I look at the top left corner of the screen, I should see a pause button, and when I press the pause button, then a menu should open with a button that says “quit”, and when I press the button, I should return to the main menu, and all progress from the level should be lost.

c) Given that I am in game, and there are many obstacles, junk parts, and junkyard dogs on screen, when I look at the top left of the  screen, I should still be able to see the pause button, and when I press the pause button, I should see a button that says “quit”, and when I press the quit button, I should return to the main menu, and all level progress from the level should be lost.

### As a player, I want to select a level on the main menu to enter the game.
a) Given that I am in the main menu, when I press the level select button, then I should see a tile for each level, and when I press a tile for a level I have unlocked,I should enter that level.

b) Given that I am in the main menu, when I press the level select button, then I should see a tile for each level, and when I press a tile for a level that I have not unlocked, I should not enter the level, and it should play a disheartening sound.

c) Given that I am in the main menu, when I press the level select button, I should see a tile for each level, and tiles that correspond to a level that I have not unlocked should be grayed out.

### As a player in game, I want to be able to jump to the next platform, so that I can collect coffee. 
a) Given that I am on a platform, when a new platform appears, I should be able to reach it from the previously generated platform.

b) Given that I am on a platform, when I fail to jump to the next platform, the next spawned platform should be reachable from the ground.

c) Given that I am in game, when a new platform appears, there should be coffee on it.


## Iteration 2:
### As a player in game, I want to see my score bar and collect coffee to increase my score bar.
a) Given I am in the main menu, when I start the game, then my score should be zero.

b) Given I am in game, when I continue and don't lose my score should increase.

c) Given I am in game, when I finish the level my score shouldn't decrease.

### As a player in game, I want to be able to jump to the next platform, so that I can collect coffee.

a) Given that I am on a platform, when a new platform appears, I should be able to reach it from the previously generated platform.

b) Given that I am on a platform, when I fail to jump to the next platform, the next spawned platform should be reachable from the ground.

c) Given that I am in game, when a new platform appears, there should be coffee on it.

### As a player, I want to see obstacles, so that if I hit the obstacles my score decreases

a) Given there is an obstacle, when the player collides with it, then the coffee bar should decrease

b) Given there is an obstacle, when the player avoids the obstacle, then the coffee bar should act normally.

c) Given there is an obstacle, when the player falls into the obstacle, then the coffee bar should decrease.


## Iteration 3:

### As a player, I want to be able to die, so that the game can end.

a) Given I am in game and at high enough coffee, when I take damage but not enough to die, then I should continue playing.

b) Given I am in game and at a low coffee, when I take enough damage to die, then I should see the game over screen.

c) Given I am in game, at a low coffee level, when the coffee bar 'ticks' to zero, then I should see the game over screen.


### As a player, I want to be able to collect power-ups, so that I can run faster and be invincible.

a) Given I am in game, when I pickup a power up, then I should increase speed.

b) Given I am in game, when I pick up a power up, then I should not take damage from obstacles.

c) Given I am in game, when I pick up a power up, then its effects should only last a short amount of time.


### As a player, so that I can be challenged appropriately, I want platforms to spawn within reach of my jump. 

a) Given that I am on the ground, when a new platform spawns, it should be easily reachable with a jump.

b) Given that I am on a platform, when a new platform spawns, it should be within half of the screen height of my player.

c) Given that I am on a platform, and I fall from the platform, the next platform that spawns should be reachable by a jump from the ground.

## Excluded Warnings:
### Android
Basically, Google wants us to use newer versions of the API, but our project uses older versions, so we say, "no!"
### Java
#### Class Structure
The collision class has a lot of unused functionality that we've decided to keep.
#### Declaration Redundancy
Again, the collision class has a lot of unused functionality that we've decided to keep.
#### Probable Bugs
IDEA Annotations are temperamental. I've tried to resolve it, but it will not comply.
### Properties Files
Unused property "target=android-19" is for another IDE. It is left in case someone decides to use that IDE.
### Spelling
All Spelling Errors are intended (probably). Usually, either words are connected or words are not in dictionary.


