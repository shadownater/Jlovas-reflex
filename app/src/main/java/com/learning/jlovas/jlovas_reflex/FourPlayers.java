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

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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

public class FourPlayers extends ActionBarActivity {

    FourPlayerClass buzzerstats = new FourPlayerClass();
    private static final String FILENAME = "fourPlayers.sav";

    public void buttonPress4p(View view){

        //StackOverFlow
        //Vitali Olshevski, http://stackoverflow.com/questions/13032333/droid-how-to-get-button-id-from-onclick-method-described-in-xml, Sept 27 2015
        //http://stackoverflow.com/users/274517/vitali-olshevski


        switch(view.getId()) {
            case R.id.p1Button4p:
                //display text that player1 touched button first
                //credit for toast tutorial:
                //Nilanchala, http://javatechig.com/android/android-toast-example, Sept 23, 2015


                //increase the points of the player
                buzzerstats.increasePlayerOne();
                Toast.makeText(getApplicationContext(), "Player One has " + buzzerstats.getPlayerOne() + " points!", Toast.LENGTH_SHORT).show();
                saveInFile();
                break;

            case R.id.p2Button4p:
                //display text that player2 touched button first

                buzzerstats.increasePlayerTwo();
                Toast.makeText(getApplicationContext(), "Player Two has " + buzzerstats.getPlayerTwo() + " points!", Toast.LENGTH_SHORT).show();
                saveInFile();
                break;

            case R.id.p3Button4p:
                //display text that player3 touched button first

                buzzerstats.increasePlayerThree();
                Toast.makeText(getApplicationContext(), "Player Three has " + buzzerstats.getPlayerThree() + " points!", Toast.LENGTH_SHORT).show();
                saveInFile();
                break;

            case R.id.p4Button4p:
                //display text that player4 touched button first

                buzzerstats.increasePlayerFour();
                Toast.makeText(getApplicationContext(), "Player Four has " + buzzerstats.getPlayerFour() + " points!", Toast.LENGTH_SHORT).show();
                saveInFile();
                break;


        }


    }

    //credit for saveInFile and loadFromFile
    //UAlberta CMPUT 301, CMPUT 301 Lab Materials by Joshua Campbell, Sept 23, 2015
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            //making container for Gson object
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(buzzerstats, out);
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

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //credit for Gson:
            //Google, https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
            Type objectType = new TypeToken<FourPlayerClass>() {}.getType();
            buzzerstats = gson.fromJson(in, objectType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            buzzerstats = new FourPlayerClass();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_players);
    }
    //onStart: how to use/understand how it works from
    //Dr. Abram Hindle, CMPUT 301 Fall 2015 Slide image under Apache II license, Android Opensource Project
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //PLEASE NOTE: I have made the assumption that players would like to
        //return to the score in which they had left off.
        //load the previous game to continue playing when you come back
        loadFromFile();
    }

}
/*Portions of this page are reproduced from work created and shared by the
  Android Open Source Project and used according to terms described in the
  Creative Commons 2.5 Attribution License.
 */
