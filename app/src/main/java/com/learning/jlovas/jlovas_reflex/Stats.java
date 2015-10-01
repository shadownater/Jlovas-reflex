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

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Stats extends ActionBarActivity {

    private static final String FILENAME1 = "reactionTimer.sav";
    private static final String FILENAME2 = "twoPlayers.sav";
    private static final String FILENAME3 = "threePlayers.sav";
    private ArrayList<ReactStatClass> reactStatArray = new ArrayList<ReactStatClass>();
    public TextView myReactionStatsText;
    public TextView twoPlayerStatsText;
    public TextView threePlayerStatsText;
    TwoPlayerClass buzzerStats2 = new TwoPlayerClass();
    ThreePlayerClass buzzerStats3 = new ThreePlayerClass();

    //button linkage
    public void emailStatsButton(View view){
        Intent intent = new Intent(Stats.this, EmailStats.class);
        startActivity(intent);

    }

    public void clearStatsButton(View view){
        //add a way to clear the stats in here!
        buzzerStats2.clear();
        buzzerStats3.clear();
        saveTwoPlayerInFile();
        saveThreePlayerInFile();
        //update text
        twoPlayerStatsText.setText("Player One: " + buzzerStats2.getPlayerOne() + " Player Two: " + buzzerStats2.getPlayerTwo());
        threePlayerStatsText.setText("Player One: " + buzzerStats3.getPlayerOne() + " Player Two: " + buzzerStats3.getPlayerTwo() + " Player Three: " + buzzerStats3.getPlayerThree());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        myReactionStatsText = (TextView)findViewById(R.id.reactionStats);
        twoPlayerStatsText = (TextView)findViewById(R.id.twoPlayerStats);
        threePlayerStatsText = (TextView)findViewById(R.id.threePlayerStats);
        //don't put loads in here! will only do it once!
    }

    //need to call onStart to update stats each visit to the activity!
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadReactionStatsFromFile();
        loadTwoPlayerFromFile();
        loadThreePlayerFromFile();
        //COME BACK TO ME AFTER TO DO THE MATH AND PASS PROPERLY
        myReactionStatsText.setText(reactStatArray + "");
        twoPlayerStatsText.setText("Player One: " + buzzerStats2.getPlayerOne() + " Player Two: " + buzzerStats2.getPlayerTwo());
        threePlayerStatsText.setText("Player One: " + buzzerStats3.getPlayerOne() + " Player Two: " + buzzerStats3.getPlayerTwo() + " Player Three: " + buzzerStats3.getPlayerThree());
        }

    //credit for loadInFile:
    //UAlberta CMPUT 301, CMPUT 301 Lab Materials by Joshua Campbell, Sept 23, 2015
    private void loadReactionStatsFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME1);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //credit for Gson:
            //Google, https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type arraylistType = new TypeToken<ArrayList<ReactStatClass>>() {}.getType();
            reactStatArray = gson.fromJson(in, arraylistType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            reactStatArray = new ArrayList<ReactStatClass>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }

    private void loadTwoPlayerFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME2);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //credit for Gson:
            //Google, https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type objectType = new TypeToken<TwoPlayerClass>() {}.getType();
            buzzerStats2 = gson.fromJson(in, objectType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            buzzerStats2 = new TwoPlayerClass();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }

    private void loadThreePlayerFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME3);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //credit for Gson:
            //Google, https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type objectType = new TypeToken<ThreePlayerClass>() {}.getType();
            buzzerStats3 = gson.fromJson(in, objectType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            buzzerStats3 = new ThreePlayerClass();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }

    //credit for saveInFile and loadFromFile
    //UAlberta CMPUT 301, CMPUT 301 Lab Materials by Joshua Campbell, Sept 23, 2015
    private void saveTwoPlayerInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME2, 0);
            //making container for Gson object
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(buzzerStats2, out);
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

    private void saveThreePlayerInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME3, 0);
            //making container for Gson object
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(buzzerStats3, out);
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

}

/*Portions of this page are reproduced from work created and shared by the
  Android Open Source Project and used according to terms described in the
  Creative Commons 2.5 Attribution License.
 */