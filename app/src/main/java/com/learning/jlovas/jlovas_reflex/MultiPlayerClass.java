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
 * Consulted with Nicole Lovas and Linda Zhang over inheritence possibilities (see xPlayerClass classes)
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
