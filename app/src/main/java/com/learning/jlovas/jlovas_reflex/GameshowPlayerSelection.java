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

public class GameshowPlayerSelection extends ActionBarActivity {

    //button stuff
    //buttons from 2-4 players needing activity function calls


    public void twoPlayersButton(View view){
        Intent intent = new Intent(GameshowPlayerSelection.this, TwoPlayers.class);
        startActivity(intent);
    }

    public void threePlayersButton(View view){
        Intent intent = new Intent(GameshowPlayerSelection.this, ThreePlayers.class);
        startActivity(intent);
    }

    public void fourPlayersButton(View view){
        Intent intent = new Intent(GameshowPlayerSelection.this, FourPlayers.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameshow_player_selection);
    }


}
