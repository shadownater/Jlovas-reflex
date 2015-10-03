package com.learning.jlovas.jlovas_reflex;

/**
 * This class is used to store the data of the Four Player mode in Gameshow.
 * It inherits from the Multiplayer class to gain its four player variables and getters/increasers.
 */
public class FourPlayerClass extends MultiPlayerClass {

    //constructor of the class - set all players scores to initally 0.
    public FourPlayerClass(){
        super();
    }

    //get score of p1
    public int getPlayerOne() {
        int gotp1 = super.getPlayerOne();
        return gotp1;

    }
    //get score of p2
    public int getPlayerTwo(){
        int gotp2 = super.getPlayerTwo();
        return gotp2;

    }

    //get score of p3
    public int getPlayerThree(){
        int gotp3 = super.getPlayerThree();
        return gotp3;

    }

    //get score of p4
    public int getPlayerFour(){
        int gotp4 = super.getPlayerFour();
        return gotp4;
    }

    //below are called to increase the score of x player.
    public void increasePlayerOne(){
        super.increasePlayerOne();
    }

    public void increasePlayerTwo(){
        super.increasePlayerTwo();
    }

    public void increasePlayerThree(){
        super.increasePlayerThree();
    }

    public void increasePlayerFour(){ super.increasePlayerFour();}


    //clear the scores of the players in four player mode
    public void clear(){
        super.clearPlayerOne();
        super.clearPlayerTwo();
        super.clearPlayerThree();
        super.clearPlayerFour();
    }

}
