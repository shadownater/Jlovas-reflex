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

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Use the CalculatorClass to calculate the appropriate stats for each required statistic
 * on the stats page. An arrayList of the collected objects from the reactionTimer
 * is passed in and various calculations can be done on the data inside them.
 * This is only for the reaction timer.
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

    //consulted with Nicole Lovas over the implementation of some of these methods. Oct 2-3, 2015


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

    //calculates the median of all latencies in the array
    public void calcMedAll(ArrayList<ReactStatClass> array){
        //consulted with Nicole Lovas on how to potentially calculate the median when
        //the list is unsorted. Utilizing knowledge from previous college, GPRC,
        //to use the sort method in Array.

        //Remembering how to use the Arrays:
        //Armando Flores, http://examples.javacodegeeks.com/core-java/util/arrays/java-util-arrays-example/, Oct 3,2015

        if(!array.isEmpty()) {
            long[] secondArray = new long[array.size()];

            //copy latencies into this array
            int i = 0;
            while (i != array.size()) {
                //move the latencies into the array
                secondArray[i] = array.get(i).getLatency();
                i++;
            } //end of while

            //now that all latencies are in the new array, we can call sort on it
            Arrays.sort(secondArray);

                //now have to grab median. Depends on even or odd # of things
                if (array.size() % 2 == 1) {
                    //get in here if odd number of things. Easier to deal with
                    int middle = array.size() / 2;

                    medAll = secondArray[middle];

                } else {
                    if (array.size() % 2 == 0) {
                        //if in here, it is even, so grab two center numbers and avg them
                        int middle1 = array.size() / 2;
                        int middle2 = middle1 - 1;

                        medAll = (secondArray[middle1] + secondArray[middle2]) / 2;

                    }
                }//end of else

        }// here if array is empty
        else{
            medAll=0;
        }


    }


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

    //calculates the med of the last 10 entries
    public void calcMedTen(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 10) {
                long[] secondArray = new long[10];

                //copy last ten latencies into this array
                int counter = 10;
                int i=0;
                while (counter > 0) {
                    //move the latencies into the array
                    secondArray[i] = array.get(array.size()-counter).getLatency();
                    i++;
                    counter--;
                } //end of while

                //now that all latencies are in the new array, we can call sort on it
                Arrays.sort(secondArray);

                //in here will always be 10 so even, don't worry about odd calculation
                medTen = (secondArray[4] + secondArray[5]) / 2;

            }else { //here if less than 10 items
                //therefore it's the same as medAll
                medTen = medAll;
            }
        }// here if array is empty
        else{
            medTen=0;
        }

    }

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

    //calculates the med of the last 100 entries
    public void calcMedHun(ArrayList<ReactStatClass> array){
        if(!array.isEmpty()) {
            if (array.size() >= 100) {
                long[] secondArray = new long[100];

                //copy last ten latencies into this array
                int counter = 100;
                int i=0;
                while (counter > 0) {
                    //move the latencies into the array
                    secondArray[i] = array.get(array.size()-counter).getLatency();
                    i++;
                    counter--;
                } //end of while

                //now that all latencies are in the new array, we can call sort on it
                Arrays.sort(secondArray);

                //in here will always be 10 so even, don't worry about odd calculation
                medTen = (secondArray[49] + secondArray[50]) / 2;

            }else { //here if less than 10 items
                //therefore it's the same as medAll
                medHun = medAll;
            }
        }// here if array is empty
        else{
            medHun=0;
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


}
