package com.learning.jlovas.jlovas_reflex;

import java.util.ArrayList;

/**
 * Plan for use: array will be popped out of Gson in stats
 * -> after that, the array will be passed to this and math will be done and stored in the instance of the class (?)
 */
public class CalculatorClass{
    private long maxAll;
    private long maxTen;
    private long maxHun;
    private long minAll;
    private long minTen;
    private long minHun;
    private long avgAll;
    private long avgTen;
    private long avgHun;
    private long medAll;
    private long medTen;
    private long medHun;

    public CalculatorClass() {
        //just set all to 0 for now
        maxAll=0;
        maxTen=0;
        maxHun=0;

        minAll=0;
        minTen=0;
        minHun=0;

        avgAll=0;
        avgTen=0;
        avgHun=0;

        medAll=0;
        medTen=0;
        medHun=0;
    }

    //clears the data
    public void clear(ArrayList<ReactStatClass> array){

        array.clear();

        maxAll=0;
        maxTen=0;
        maxHun=0;

        minAll=0;
        minTen=0;
        minHun=0;

        avgAll=0;
        avgTen=0;
        avgHun=0;

        medAll=0;
        medTen=0;
        medHun=0;

    }

    //calculates the max of all latencies in the array
    public void calcMaxAll(ArrayList<ReactStatClass> array){
        //will require looping!
        if(!array.isEmpty()) {
            maxAll = array.get(0).getLatency();

            int i=0;
            while (array.size() > i) {
                if (maxAll < array.get(i).getLatency()){
                    maxAll= array.get(i).getLatency();
                }
                i++;
            } //end of while

        }//end of if
        else {
            //if it is empty, just leave it as is, at 0.
            maxAll = 0;
        }
    }

    //calculates the min of all latencies in the array
    public void calcMinAll(ArrayList<ReactStatClass> array){
        //will require looping!
        if(!array.isEmpty()) {
            minAll = array.get(0).getLatency();

            int i=0;
            while (array.size() > i) {
                if (minAll > array.get(i).getLatency()){
                    minAll= array.get(i).getLatency();
                }
                i++;
            } //end of while

        }//end of if
        else {
            //if it is empty, just leave it as is, at 0.
            minAll = 0;
        }
    }

    //calculates the avg of all latencies in the array
    public void calcAvgAll(ArrayList<ReactStatClass> array){
        //will require looping!
        if(!array.isEmpty()) {
            avgAll=0;
            int i=0;
            while (array.size() > i) {
                avgAll += array.get(i).getLatency();
                i++;
            } //end of while
            //calculate avg
            avgAll /= array.size();

        }//end of if
        else {
            //if it is empty, just leave it as is, at 0.
            avgAll = 0;
        }
    }

    ////////////WRITE calMedAll HERE!!!!


    //calculates the max of the last 10 reactions
    public void calcMaxTen(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 10) {
                //we have to have at least 10 items to do this
                int counter = 10;
                maxTen = array.get(array.size() - counter).getLatency();
                while (counter > 0) {
                    if (maxTen < array.get(array.size() - counter).getLatency()) {
                        maxTen = array.get(array.size() - counter).getLatency();
                    }
                    counter--;
                } //end of while

            } else {
                //only here if less than 10 items, will calculate based on what we have, so will be
                //the same as maxAll
                maxTen = maxAll;
            }
        }else {
            //get here if array is empty
            maxTen = 0;
        }
    }

    //calculates the min of the last 10 reactions
    public void calcMinTen(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 10) {
                //we have to have at least 10 items to do this
                int counter = 10;
                minTen = array.get(array.size()-counter).getLatency();
                while (counter > 0) {
                    if (minTen > array.get(array.size() - counter).getLatency()) {
                        minTen = array.get(array.size() - counter).getLatency();
                    }
                    counter--;
                } //end of while

            } else {
                //only here if less than 10 items, will calculate based on what we have, so will be
                //the same as minAll
                minTen = minAll;
            }
        }
        //get here is array is empty
        else{
            minTen=0;
        }
    }

    //calculates the avg of the last 10 reactions
    public void calcAvgTen(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 10) {
                //we have to have at least 10 items to do this
                int counter = 10;
                avgTen = 0;
                while (counter > 0) {
                    avgTen += array.get(array.size() - counter).getLatency();
                    counter--;
                } //end of while
                avgTen /= 10;

            } else {
                //only here if less than 10 items, will calculate based on what we have, so will be
                //the same as avgAll
                avgTen = avgAll;
            }
        }
        //get here if array is empty
        else{
            avgTen=0;
        }
    }

    //////////ADD calcMedTen HERE!!!!

    //calculates the max of the last 100 entries
    public void calcMaxHun(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 100) {
                int counter = 100;
                maxHun = 0;
                while (counter > 0) {
                    if (maxHun < array.get(array.size() - counter).getLatency()) {
                        maxHun = array.get(array.size() - counter).getLatency();
                    }
                    counter--;
                }//end of while

            } else {
                //get here if less than 100 entries
                //if it's less than 100 entries, than it's maxAll again
                maxHun = maxAll;
            }
        }
        //get here if array is empty
        else{
            maxHun=0;
        }
    }
    //calculates the min of the last 100 entries
    public void calcMinHun(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 100) {
                int counter = 100;
                minHun = 0;
                while (counter > 0) {
                    if (minHun > array.get(array.size() - counter).getLatency()) {
                        minHun = array.get(array.size() - counter).getLatency();
                    }
                    counter--;
                }//end of while

            } else {
                //get here if less than 100 entries
                //if it's less than 100 entries, than it's minAll again
                minHun = minAll;
            }
        }
        //here if array empty
        else{
            minHun=0;
        }
    }

    //calculates the avg of the last 100 entries
    public void calcAvgHun(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 100) {
                int counter = 100;
                avgHun = 0;
                while (counter > 0) {
                    avgHun = array.get(array.size() - counter).getLatency();
                    counter--;
                }//end of while
                avgHun /= 100;
            } else {
                //get here if less than 100 entries
                //if it's less than 100 entries, than it's avgAll again
                avgHun = avgAll;
            }
        }
        //here if empty
        else{
            avgHun=0;
        }
    }

    //getters down below

    public long getMaxAll() {
        return maxAll;
    }

    public long getMaxTen() {
        return maxTen;
    }

    public long getMaxHun() {
        return maxHun;
    }

    public long getMinAll() {
        return minAll;
    }

    public long getMinTen() {
        return minTen;
    }

    public long getMinHun() {
        return minHun;
    }

    public long getAvgAll() {
        return avgAll;
    }

    public long getAvgTen() {
        return avgTen;
    }

    public long getAvgHun() {
        return avgHun;
    }

    public long getMedAll() {
        return medAll;
    }

    public long getMedTen() {
        return medTen;
    }

    public long getMedHun() {
        return medHun;
    }


    //HERE look at how they pull it out into an arraylist here:
    //https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html

}
