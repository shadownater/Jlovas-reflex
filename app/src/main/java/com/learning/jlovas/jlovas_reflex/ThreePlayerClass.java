package com.learning.jlovas.jlovas_reflex;

/**
 * Created by jlovas on 10/1/15.
 */
public class ThreePlayerClass extends MultiPlayerClass {
    //private int twoPlayer1p;
    //private int twoPlayer2p;


    public ThreePlayerClass() {
        super();

    }

    public int getPlayerOne() {
        int gotp1 = super.getPlayerOne();
        return gotp1;

    }
    public int getPlayerTwo(){
        int gotp2 = super.getPlayerTwo();
        return gotp2;

    }

    public int getPlayerThree(){
        int gotp3 = super.getPlayerThree();
        return gotp3;

    }

    public void increasePlayerOne(){
        super.increasePlayerOne();
    }

    public void increasePlayerTwo(){
        super.increasePlayerTwo();
    }

    public void increasePlayerThree(){
        super.increasePlayerThree();
    }

    //write the clear later! :D
    public void clear(){
        super.clearPlayerOne();
        super.clearPlayerTwo();
        super.clearPlayerThree();
    }
}
