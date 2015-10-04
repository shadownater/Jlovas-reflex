/*      Jlovas-reflex: A buzzer game with different reaction functionalities.
        Copyright (C) 2015  Jillian Lovas. jlovas@ualberta.ca

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package com.learning.jlovas.jlovas_reflex;

/**
 * This class is used to store the data of the Four Player mode in Gameshow.
 * It inherits from the Multiplayer class to gain its four player variables and getters/increasers.
 * Consulted with Linda Zhang and Nicole Lovas on implementing ideas.
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
