package com.learning.jlovas.jlovas_reflex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GameshowPlayerSelection extends ActionBarActivity {

    //button stuffs
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gameshow_player_selection, menu);
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
