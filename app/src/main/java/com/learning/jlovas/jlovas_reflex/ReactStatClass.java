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


public class ReactStatClass {
    private boolean tooFast;
    private long time;
    private long latency;
    private long countDownStarted;

    public ReactStatClass() {
        tooFast = true;
        time=System.currentTimeMillis();

        //will change later as called
        latency =0;
        countDownStarted=0;
    }


    //returns true if clicked too fast, false if it's been ok to click
    public boolean isTooFast(){
        return this.tooFast;
    }

    //sets the start time of when it is ok to tap the button
    public void setTime(long time) {
        this.time = time;
    }

    //sets the time for when the countDown has started
    public void setCountDownStarted(long countDownStarted) {
        this.countDownStarted = countDownStarted;
    }

    //calculates the latency, only for use within the class
    public void calculateLatency(){
        //do the calculation here!
        this.latency = this.time - this.countDownStarted;
    }

    //uses the private function to calculate latency and returns the value to the user
    public long getLatency() {
        return latency;
    }

    public void setTooFast(boolean b){
        this.tooFast=b;
    }
}
