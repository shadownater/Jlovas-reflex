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
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class EmailStats extends ActionBarActivity {

    EditText enteredEmail;
    String []myEmail;
    String subject = new String("Your Buzzer statistics");

    //files to load from
    private static final String FILENAME = "calculatedStats.sav";
    private static final String FILENAME2 = "twoPlayers.sav";
    private static final String FILENAME3 = "threePlayers.sav";
    private static final String FILENAME4 = "fourPlayers.sav";

    //objects to copy my data for the files
    TwoPlayerClass buzzerStats2 = new TwoPlayerClass();
    ThreePlayerClass buzzerStats3 = new ThreePlayerClass();
    FourPlayerClass buzzerStats4 = new FourPlayerClass();

    CalculatorClass calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_stats);

        //declare UI goodies
        enteredEmail = (EditText)findViewById(R.id.emailText);
        calc = new CalculatorClass();
        buzzerStats2 = new TwoPlayerClass();
        buzzerStats3 = new ThreePlayerClass();
        buzzerStats4 = new FourPlayerClass();

    }
    //button to send your email!
    public void emailStatsButton(View view){
        //take the entered email and send email to it with all goods attached
        myEmail = new String[]{enteredEmail.getText().toString()};
            sendEmail(myEmail);
        }

    //this method is used to send the email
    private void sendEmail(String []myEmail) {
        //have to change the stats into strings so it can be sent
        loadCalculatorFromFile();
        loadTwoPlayerFromFile();
        loadThreePlayerFromFile();
        loadFourPlayerFromFile();

        String message = new String("Reaction Timer Statistics:\nMax all: " + calc.getMaxAll() + "\nMax of last ten: " +calc.getMaxTen() +
                "\nMax of last hundred: " + calc.getMaxHun() + "\nMin all: " + calc.getMinAll() + "\nMin of last ten: " +
                calc.getMinTen() + "\nMin of last hundred: " + calc.getMinHun() + "\nAverage All: " +calc.getAvgAll() +
                "\nAverage Ten: " + calc.getAvgTen() + "\nAverage of last hundred: " + calc.getAvgHun() + "\nMedian all: " + calc.getMedAll() +
                "\nMedian of last ten: " + calc.getMedTen() + "\nMedian of last hundred: " + calc.getMedHun() +
                "\nGameshow Buzzer Statistics:\nTwo Player Mode:\nPlayer One: " + buzzerStats2.getPlayerOne() +
                "\nPlayer Two: " +buzzerStats2.getPlayerTwo() + "\nThree Player Mode:\nPlayer One: " +buzzerStats3.getPlayerOne() +
                "\nPlayer Two: " + buzzerStats3.getPlayerTwo() + "\nPlayer Three: " +buzzerStats3.getPlayerThree() +
                "\nFour Player Mode:\nPlayer One: " +buzzerStats4.getPlayerOne() + "\nPlayer Two: " + buzzerStats4.getPlayerTwo() +
                "\nPlayer Three: " +buzzerStats4.getPlayerThree() + "\nPlayer Four: " + buzzerStats4.getPlayerFour());

        //Credit for how to email:
        //profgustin, https://www.youtube.com/watch?v=V1tAL0kjjuU, Oct 3rd, 2015
        Intent sendTheEmail = new Intent(Intent.ACTION_SEND);
        sendTheEmail.putExtra(Intent.EXTRA_EMAIL, myEmail);
        sendTheEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendTheEmail.putExtra(Intent.EXTRA_TEXT, message);
        sendTheEmail.setType("message/rfc822");
        startActivity(Intent.createChooser(sendTheEmail, "Email"));

    }

    //credit for loadInFiles/saveInFiles:
    //UAlberta CMPUT 301, CMPUT 301 Lab Materials by Joshua Campbell, Sept 23, 2015
    private void loadCalculatorFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //credit for Gson:
            //Google, https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type objectType = new TypeToken<CalculatorClass>() {}.getType();
            calc = gson.fromJson(in, objectType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            calc = new CalculatorClass();
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

    private void loadFourPlayerFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME4);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //credit for Gson:
            //Google, https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type objectType = new TypeToken<FourPlayerClass>() {}.getType();
            buzzerStats4 = gson.fromJson(in, objectType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            buzzerStats4 = new FourPlayerClass();
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
