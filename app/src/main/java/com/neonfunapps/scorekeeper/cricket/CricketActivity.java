package com.neonfunapps.scorekeeper.cricket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.neonfunapps.scorekeeper.R;

public class CricketActivity extends AppCompatActivity {

    // counting points
    private int teamAScore = 0;
    private int teamBScore = 0;
    private Button mButton1runTeamA;
    private Button mButton4runsTeamA;
    private Button mButton6runsTeamA;
    private Button mButton1runTeamB;
    private Button mButton4runsTeamB;
    private Button mButton6runsTeamB;
    private Button mMinus1runTeamA;
    private Button mMinus4runsTeamA;
    private Button mMinus6runsTeamA;
    private Button mMinus1runTeamB;
    private Button mMinus4runsTeamB;
    private Button mMinus6runsTeamB;
    private Button mButtonResetPoints;
    private TextView mPointsTeamA;
    private TextView mPointsTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_cricket_activity);

        Toolbar mToolbar = findViewById(R.id.cricket_toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mButton1runTeamA = findViewById(R.id.button1runTeamA);
        mButton4runsTeamA = findViewById(R.id.button4runsTeamA);
        mButton6runsTeamA = findViewById(R.id.button6runsTeamA);
        mButton1runTeamB = findViewById(R.id.button1runTeamB);
        mButton4runsTeamB = findViewById(R.id.button4runsTeamB);
        mButton6runsTeamB = findViewById(R.id.button6runsTeamB);
        mMinus1runTeamA = findViewById(R.id.minus1runTeamA);
        mMinus4runsTeamA = findViewById(R.id.minus4runsTeamA);
        mMinus6runsTeamA = findViewById(R.id.minus6runsTeamA);
        mMinus1runTeamB = findViewById(R.id.minus1runTeamB);
        mMinus4runsTeamB = findViewById(R.id.minus4runsTeamB);
        mMinus6runsTeamB = findViewById(R.id.minus6runsTeamB);
        mButtonResetPoints = findViewById(R.id.pointsReset);

        mPointsTeamA = findViewById(R.id.pointsTeamA);
        mPointsTeamB = findViewById(R.id.pointsTeamB);

        mPointsTeamA.setText("0");
        mPointsTeamB.setText("0");

        mButton1runTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 1;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButton4runsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 4;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButton6runsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 6;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButton1runTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 1;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mButton4runsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 4;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mButton6runsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 6;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mMinus1runTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore -= 1;
                if (teamAScore > 0) {
                    String teamAScoreString = Integer.toString(teamAScore);
                    mPointsTeamA.setText(teamAScoreString);
                } else {
                    teamAScore = 0;
                    mPointsTeamA.setText("0");
                }

            }
        });

        mMinus4runsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore -= 4;
                if (teamAScore >= 0) {
                    String teamAScoreString = Integer.toString(teamAScore);
                    mPointsTeamA.setText(teamAScoreString);
                } else {
                    teamAScore = 0;
                    mPointsTeamA.setText("0");
                }

            }
        });

        mMinus6runsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore -= 6;
                if (teamAScore >= 0) {
                    String teamAScoreString = Integer.toString(teamAScore);
                    mPointsTeamA.setText(teamAScoreString);
                } else {
                    teamAScore = 0;
                    mPointsTeamA.setText("0");
                }

            }
        });

        mMinus1runTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore -= 1;
                if (teamBScore >= 0) {
                    String teamBScoreString = Integer.toString(teamBScore);
                    mPointsTeamB.setText(teamBScoreString);
                } else {
                    teamBScore = 0;
                    mPointsTeamB.setText("0");
                }

            }
        });

        mMinus4runsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore -= 4;
                if (teamBScore >= 0) {
                    String teamBScoreString = Integer.toString(teamBScore);
                    mPointsTeamB.setText(teamBScoreString);
                } else {
                    teamBScore = 0;
                    mPointsTeamB.setText("0");
                }

            }
        });

        mMinus6runsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore -= 6;
                if (teamBScore >= 0) {
                    String teamBScoreString = Integer.toString(teamBScore);
                    mPointsTeamB.setText(teamBScoreString);
                } else {
                    teamBScore = 0;
                    mPointsTeamB.setText("0");
                }

            }
        });

        mButtonResetPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore = 0;
                teamBScore = 0;
                String teamAScoreString = Integer.toString(teamAScore);
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamA.setText(teamAScoreString);
                mPointsTeamB.setText(teamBScoreString);
            }
        });
    }
}