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

public class ThreePlayers extends ActionBarActivity {

    //My class object
    ThreePlayerClass buzzerstats = new ThreePlayerClass();
    private static final String FILENAME = "threePlayers.sav";

    //listen for who clicks the button
    //credit for using case switch id method:


    public void buttonPress3p(View view){

        switch(view.getId()) {
            case R.id.playerOne3pButton:
                //display text that player1 touched button first
                //credit goes here for toast tutorial

                //increase the points of the player
                buzzerstats.increasePlayerOne();
                Toast.makeText(getApplicationContext(), "Player One has " + buzzerstats.getPlayerOne() + " points!", Toast.LENGTH_SHORT).show();
                saveInFile();
                break;

            case R.id.playerTwo3pButton:
                //display text that player2 touched button first

                buzzerstats.increasePlayerTwo();
                Toast.makeText(getApplicationContext(), "Player Two has " + buzzerstats.getPlayerTwo() + " points!", Toast.LENGTH_SHORT).show();
                saveInFile();
                break;

            case R.id.playerThree3pButton:
                //display text that player3 touched button first

                buzzerstats.increasePlayerThree();
                Toast.makeText(getApplicationContext(), "Player Three has " + buzzerstats.getPlayerThree() + " points!", Toast.LENGTH_SHORT).show();
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
            Type objectType = new TypeToken<ThreePlayerClass>() {}.getType();
            buzzerstats = gson.fromJson(in, objectType );
            //have put the data into the reactStatArray
            //or we make a new one if no data to load

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            buzzerstats = new ThreePlayerClass();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_players);
    }

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
