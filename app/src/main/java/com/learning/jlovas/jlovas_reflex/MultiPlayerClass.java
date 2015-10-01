package com.learning.jlovas.jlovas_reflex;

/**
 * Created by jlovas on 10/1/15.
 */
public class MultiPlayerClass {
    private int playerOne;
    private int playerTwo;
    private int playerThree;
    private int playerFour;

    //set to 0 for all extended classes
    public MultiPlayerClass() {
        playerOne=0;
        playerTwo=0;
        playerThree=0;
        playerFour=0;
    }

    public int getPlayerOne(){
        return playerOne;
    }

    public int getPlayerTwo(){
        return playerTwo;
    }

    public int getPlayerThree(){
        return playerThree;
    }

    public void increasePlayerOne(){
        this.playerOne++;
    }

    public void increasePlayerTwo(){
        this.playerTwo++;
    }

    public void increasePlayerThree(){
        this.playerThree++;
    }

    public void clearPlayerOne(){
        playerOne=0;
    }

    public void clearPlayerTwo(){
        playerTwo=0;
    }

    public void clearPlayerThree(){
        playerThree=0;
    }
}
