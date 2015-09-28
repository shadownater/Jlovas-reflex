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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_timer);

        //credit for this goes to background changing link


        //grab current time - credit to Nicole Lovas for informing me of this function
        //consulting with Nicole Lovas over implementation

        //will create a random time to start
        long startRandom = (long) (Math.random() *(2001 - 10) + 10);
        ///////////////////////////////
        //ATTEMPT #2
        //CountDownTimer way
        countDownTimer = new MyCountDownTimer(startRandom, 1000);
        background = (RelativeLayout) findViewById(R.id.bg);

        //start the countdown
        countDownTimer.start();
        tooFast=true;
        countDownStarted = (long)System.currentTimeMillis();

    } //end of onCreate

    //set up of the timer to my button
    public void pushedButton(View view) {
        if(tooFast){
            //get here if going too fast
            Intent intent = new Intent(this, TooSoon.class);
            startActivity(intent);
        }
        else{
            long time = System.currentTimeMillis();
            long latency = time - countDownStarted;
            Toast.makeText(getApplicationContext(), "Latency is " + latency, Toast.LENGTH_SHORT).show();
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
        tooFast=false;
        }

    @Override
    public void onTick(long millisUntilFinished) {
        //don't need this, not showing any time stuff
        }

    }


}
