package com.learning.jlovas.jlovas_reflex;

/**
 * Created by jlovas on 9/28/15.
 */
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
    private long calculateLatency(){
        //do the calculation here!
        return latency;
    }

    //uses the private function to calculate latency and returns the value to the user
    public long getLatency() {
        this.calculateLatency(); //THIS? or no this?
        return latency;
    }
}
