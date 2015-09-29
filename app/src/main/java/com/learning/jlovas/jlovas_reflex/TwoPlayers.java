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

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TwoPlayers extends ActionBarActivity {

    //My class objects
    BuzzerStatsClass buzzerstats = new BuzzerStatsClass();

    //listen for who clicks the button
    //credit for using case switch id method:


    public void buttonPress(View view){

        switch(view.getId()) {
            case R.id.player1Button:
                //display text that player2 touched button first
                //credit goes here for toast tutorial

                //increase the points of the player
                buzzerstats.increaseTwoPlayer1p();

                Toast.makeText(getApplicationContext(), "Player One has " + buzzerstats.getTwoPlayer1p() + " points!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("playerOneStatsP2", buzzerstats);

                finish();
                break;
            case R.id.player2Button:
                //display text that player2 touched button first

                buzzerstats.increaseTwoPlayer2p();

                Toast.makeText(getApplicationContext(), "Player Two has " + buzzerstats.getTwoPlayer2p() + " points!", Toast.LENGTH_SHORT).show();
                finish();
                break;


        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_players, menu);
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
}
