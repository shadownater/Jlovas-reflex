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

        /////////////////////////////////////////////////////////////////////

                Copyright 2008-2015 Google Inc., Jillian Lovas

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

                http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/


package com.learning.jlovas.jlovas_reflex;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ReactionTimer extends ActionBarActivity {

    private CountDownTimer countDownTimer;
    public RelativeLayout background;
    ReactStatClass reactStat;
    private static final String FILENAME = "reactionTimer.sav";
    private ArrayList<ReactStatClass> reactStatArray = new ArrayList<ReactStatClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_timer);

        //grab current time - credit to Nicole Lovas for informing me of this function
        //consulting with Nicole Lovas over implementation of random and use of countDownTimer
        //Linda also mentioned using countDownTimer

        //create object
        reactStat = new ReactStatClass();

        //will create a random time to start
        long startRandom = (long) (Math.random() *(2001 - 10) + 10);

        countDownTimer = new MyCountDownTimer(startRandom, 1000);
        background = (RelativeLayout) findViewById(R.id.bg);

        //start the countdown
        countDownTimer.start();
        reactStat.setCountDownStarted((long)System.currentTimeMillis());

    } //end of onCreate

    //set up of the timer to my button
    public void pushedButton(View view) {
        if(reactStat.isTooFast()){
            //get here if going too fast
            Intent intent = new Intent(this, TooSoon.class);
            startActivity(intent);
            finish();

        }
        else{
            reactStat.setTime((long)System.currentTimeMillis());
            reactStat.calculateLatency();
            Toast.makeText(getApplicationContext(), "Latency is " + reactStat.getLatency() +" ms", Toast.LENGTH_SHORT).show();

            //put into a saving place
            reactStatArray.add(reactStat);
            saveInFile();

            //credit for restarting activity goes to:
            //EboMike, http://stackoverflow.com/questions/1397361/how-do-i-restart-an-android-activity, Sept 28, 2015
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }
    //credit for saveInFile
    //UAlberta CMPUT 301, CMPUT 301 Lab Materials by Joshua Campbell, Sept 23, 2015
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            //making container for Gson object
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(reactStatArray, out);
            out.flush(); //to print what we did
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reaction_timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//credit for CountDownTimer goes to:
//http://androidbite.blogspot.ca/2012/11/android-count-down-timer-example.html, September 27, 2015

public class MyCountDownTimer extends CountDownTimer {
    public MyCountDownTimer(long startTime, long interval) {
        super(startTime, interval);
    }

    @Override
    public void onFinish() {
        //when random time is up I go here
        background.setBackgroundColor(Color.RED);
        reactStat.setTooFast(false);
        }

    @Override
    public void onTick(long millisUntilFinished) {
        //don't need this, not showing any time stuff, but required to be here
        }

    }


}
/*Portions of this page are reproduced from work created and shared by the
  Android Open Source Project and used according to terms described in the
  Creative Commons 2.5 Attribution License.
 */