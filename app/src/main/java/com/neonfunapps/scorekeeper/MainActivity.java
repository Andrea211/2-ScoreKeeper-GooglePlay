package com.neonfunapps.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.neonfunapps.scorekeeper.badminton.BadmintonActivity;
import com.neonfunapps.scorekeeper.basketball.BasketballActivity;
import com.neonfunapps.scorekeeper.cricket.CricketActivity;
import com.neonfunapps.scorekeeper.football.FootballActivity;
import com.neonfunapps.scorekeeper.handball.HandballActivity;
import com.neonfunapps.scorekeeper.hockey.HockeyActivity;
import com.neonfunapps.scorekeeper.rugby.RugbyActivity;
import com.neonfunapps.scorekeeper.tabletennis.TabletennisActivity;
import com.neonfunapps.scorekeeper.tennis.TennisActivity;
import com.neonfunapps.scorekeeper.volleyball.VolleyballActivity;

public class MainActivity extends AppCompatActivity {
    // GridView in the first visible screen - with types of sports to choose from
    GridView mainGridView;

    // Table of sport logos
    int logos[] = {R.drawable.ic_football,
            R.drawable.ic_basketball,
            R.drawable.ic_cricket,
            R.drawable.ic_handball,
            R.drawable.ic_tennis,
            R.drawable.ic_hockey,
            R.drawable.ic_volleyball,
            R.drawable.ic_badminton,
            R.drawable.ic_table_tennis,
            R.drawable.ic_rugby};


    int colors[] = {R.color.footballColor,
            R.color.basketballColor,
            R.color.cricketColor,
            R.color.handballColor,
            R.color.tennisColor,
            R.color.hockeyColor,
            R.color.volleyballColor,
            R.color.badmintonColor,
            R.color.tabletennisColor,
            R.color.rugbyColor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String namesOfSports[] = {getResources().getString(R.string.football),
                getResources().getString(R.string.basketball),
                getResources().getString(R.string.cricket),
                getResources().getString(R.string.handball),
                getResources().getString(R.string.tennis),
                getResources().getString(R.string.hockey),
                getResources().getString(R.string.volleyball),
                getResources().getString(R.string.badminton),
                getResources().getString(R.string.tabletennis),
                getResources().getString(R.string.rugby)};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize mainGridView
        mainGridView = findViewById(R.id.gridView);
        mainGridView.setNumColumns(2);

        // Create an object of CustomAdapter and set Adapter to GirdView
        SportsAdapter customAdapter = new SportsAdapter(getApplicationContext(), logos, namesOfSports, colors);
        mainGridView.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        mainGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                if(position == 0) {
                    Intent intent = new Intent(MainActivity.this, FootballActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 1) {
                    Intent intent = new Intent(MainActivity.this, BasketballActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 2) {
                    Intent intent = new Intent(MainActivity.this, CricketActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 3) {
                    Intent intent = new Intent(MainActivity.this, HandballActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 4) {
                    Intent intent = new Intent(MainActivity.this, TennisActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 5) {
                    Intent intent = new Intent(MainActivity.this, HockeyActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 6) {
                    Intent intent = new Intent(MainActivity.this, VolleyballActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 7) {
                    Intent intent = new Intent(MainActivity.this, BadmintonActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 8) {
                    Intent intent = new Intent(MainActivity.this, TabletennisActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
                else if(position == 9) {
                    Intent intent = new Intent(MainActivity.this, RugbyActivity.class);
                    intent.putExtra("image", logos[position]); // put image data in Intent
                    intent.putExtra("text", namesOfSports[position]); // put image data in Intent
                    intent.putExtra("color", colors[position]); // put color in Intent
                    startActivity(intent); // start Intent
                }
            }
        });
    }
}