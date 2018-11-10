package edu.vcu.nopreference.Objects.base;

import com.badlogic.gdx.Gdx;

import edu.vcu.nopreference.Objects.renders.Render;

public class Score extends objectBase {
    final static float maxScore=255;
    static float score;
    float scorePercentage;
    float barWidth;

    public Score(){
        score = 255;
        render = new Render(this, "coffeeBar.png");
        setBounds(render.getScreenSizeX()-350, render.getScreenSizeY()-100, 255, 64);
    }

    @Override
    public void update() {

        score -=0.05;
        Gdx.app.log("Untitled", "score: "+score);
        if(score < 0){score=0;}
        scorePercentage = score/maxScore;
        setBounds(render.getScreenSizeX()-350, render.getScreenSizeY()-100, 255*scorePercentage, 128);
    }

    public float getScore(){
        return score;
    }

    public float getMaxScore(){
        return maxScore;
    }
    public float getModifier(){
        return scorePercentage;
    }

    //we could add different types of damage dealers, pass an int value to this and then switch statement
    //such that different amounts of damage is done.
    public void takeDamage(){
        score-=5;
        Gdx.app.log("Untitled", "score: "+score);
    }

    public void getCoffee(){
        score +=15;
    }

}
