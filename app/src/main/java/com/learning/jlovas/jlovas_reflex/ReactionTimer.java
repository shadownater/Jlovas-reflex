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

public class ReactionTimer extends ActionBarActivity {

    boolean tooFast;
    private CountDownTimer countDownTimer;
    public RelativeLayout background;
    public long countDownStarted;
    ReactStatClass reactStat;

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
            Toast.makeText(getApplicationContext(), "Latency is " + reactStat.getLatency(), Toast.LENGTH_SHORT).show();

            //credit for restarting activity goes to:
            //EboMike, http://stackoverflow.com/questions/1397361/how-do-i-restart-an-android-activity, Sept 28, 2015
            Intent intent = getIntent();
            finish();
            startActivity(intent);
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
