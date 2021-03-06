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

/*
* This class is for counting the score within the two player multiplayer game.
*
 */
package com.learning.jlovas.jlovas_reflex;

import android.os.Parcel;
import android.os.Parcelable;


public class TwoPlayerClass extends MultiPlayerClass{

    //constructor-set scores to 0 to start
     public TwoPlayerClass() {
        super();

    }
    //returns player one score
    public int getPlayerOne() {
        int gotp1 = super.getPlayerOne();
        return gotp1;

    }
    //returns player two score
    public int getPlayerTwo(){
        int gotp2 = super.getPlayerTwo();
        return gotp2;

    }
    //increases the score of p1
    public void increasePlayerOne(){
        super.increasePlayerOne();
    }
    //increases the score of p2
    public void increasePlayerTwo(){
        super.increasePlayerTwo();
    }

    //clears the score of both players to 0
    public void clear(){
        super.clearPlayerOne();
        super.clearPlayerTwo();
    }



}
