package edu.vcu.nopreference.Objects.base.inGameObjects;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.gameOverScreen;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Untitled;

public class Score extends objectBase {
    private final static float MAX_SCORE   = 255;
    public final static float START_SCORE = 230;
    public final static float SCORE_DECAY = 0.05f;

    private float score;
    private float scorePercentage;
    private boolean speedToBeReset = false;

    public Score(){
        score = START_SCORE;
        render = new Render(this, "coffeeBar2.png");
        setBounds(render.getScreenSizeX()-350, render.getScreenSizeY()-100, 255, 64);
        setDrawOrder(10);
    }

    @Override
    public void update() {
        score -= SCORE_DECAY;
        if(score < 0){
            if(!Render.testing){
                inGame.music.dispose();
            }
            Untitled.newScreen = new gameOverScreen();
        }
        scorePercentage = score/ MAX_SCORE;
        setBounds(render.getScreenSizeX()-350, render.getScreenSizeY()-100, 255*scorePercentage, 128);

        //coffee run
        if(scorePercentage>0.8 && !Player.poweredUp){
            manager.modifySpeed(1.25f);
            speedToBeReset = true;

        }
        if(scorePercentage<0.8 && speedToBeReset && !Player.poweredUp){
            manager.resetSpeed();
            speedToBeReset = false;
        }
    }

    public float getScore(){
        return score;
    }


    public float getModifier(){
        return scorePercentage;
    }

    //we could add different types of damage dealers, pass an int value to this and then switch statement
    //such that different amounts of damage is done.
    public void takeDamage(){
        score-=50;
    }

    @Override
    public void receiveIntent(String Intent, String Argument)
    {
        if(Intent.equals("+score"))
        {
            score+= Integer.parseInt(Argument);
            if(score > 1000) score = 1000;
        }
        if(Intent.equals("setscore"))
        {
            score+= Integer.parseInt(Argument);
        }
    }

    @Override
    public String requestIntent(String request) {
        if(request.equals("score"))
            return String.valueOf(score);
        return super.requestIntent(request);
    }
}
