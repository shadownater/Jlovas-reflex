package com.learning.jlovas.jlovas_reflex;

/**
 * Consulted with Nicole and Linda over inheritence possibilities (see xPlayerClass classes)
 * This class is used by the other xPlayerClasses to inherit its functions and variables.
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

    //below are the getters, which fetch the specific player's score

    public int getPlayerOne(){
        return playerOne;
    }

    public int getPlayerTwo(){
        return playerTwo;
    }

    public int getPlayerThree(){
        return playerThree;
    }

    public int getPlayerFour(){ return playerFour; }


    //here are the increasers, called to increase x player's score by 1

    public void increasePlayerOne(){
        this.playerOne++;
    }

    public void increasePlayerTwo(){
        this.playerTwo++;
    }

    public void increasePlayerThree(){
        this.playerThree++;
    }

    public void increasePlayerFour(){ this.playerFour++; }


    //here are the clearing functions, called to clear x player's score to 0

    public void clearPlayerOne(){
        playerOne=0;
    }

    public void clearPlayerTwo(){
        playerTwo=0;
    }

    public void clearPlayerThree(){
        playerThree=0;
    }

    public void clearPlayerFour() { playerFour=0; }
}
