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

        ////////////////////////////////////////////////////////////////

        This work is licensed under the Creative Commons Attribution-ShareAlike 3.0
        Unported License. To view a copy of this license, visit

                http://creativecommons.org/licenses/by-sa/3.0/

        or send a letter to Creative Commons, PO Box 1866, Mountain View,
                                CA 94042, USA.
*/


package com.learning.jlovas.jlovas_reflex;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    //Buttons on the main screen functions!
    public void reactionTimerButton(View view){
        Intent intent = new Intent(MainActivity.this, ReactionInfoPopup.class);
        startActivity(intent);
    }

    public void gameshowTimerButton(View view){
        Intent intent = new Intent(MainActivity.this, GameshowPlayerSelection.class);
        startActivity(intent);
    }

    public void statsButton(View view){
        Intent intent = new Intent(MainActivity.this, Stats.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
