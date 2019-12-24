package com.neonfunapps.scorekeeper.tabletennis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.neonfunapps.scorekeeper.R;

public class TabletennisActivity extends AppCompatActivity {

    // counting points
    private int teamAScore = 0;
    private int teamBScore = 0;
    private int finalTeamAScore = 0;
    private int finalTeamBScore = 0;
    private Button mButtonGoalTeamA;
    private Button mButtonGoalTeamB;
    private Button mMinusPointTeamA;
    private Button mMinusPointTeamB;
    private Button mFinalButtonGoalTeamA;
    private Button mFinalButtonGoalTeamB;
    private Button mFinalMinusPointTeamA;
    private Button mFinalMinusPointTeamB;
    private Button mButtonResetPoints;
    private Button mResetButtonResetPoints;
    private TextView mPointsTeamA;
    private TextView mPointsTeamB;
    private TextView mFinalPointsTeamA;
    private TextView mFinalPointsTeamB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_tabletennis_activity);

        Toolbar mToolbar = findViewById(R.id.tabletennis_toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mButtonGoalTeamA = findViewById(R.id.buttonGoalTeamA);
        mButtonGoalTeamB = findViewById(R.id.buttonGoalTeamB);
        mMinusPointTeamA = findViewById(R.id.minusPointTeamA);
        mMinusPointTeamB = findViewById(R.id.minusPointTeamB);
        mFinalButtonGoalTeamA = findViewById(R.id.finalPlusPointTeamA);
        mFinalButtonGoalTeamB = findViewById(R.id.finalPlusPointTeamB);
        mFinalMinusPointTeamA = findViewById(R.id.finalMinusPointTeamA);
        mFinalMinusPointTeamB = findViewById(R.id.finalMinusPointTeamB);
        mButtonResetPoints = findViewById(R.id.goalsReset);
        mResetButtonResetPoints = findViewById(R.id.finalGoalsReset);

        mPointsTeamA = findViewById(R.id.pointsTeamA);
        mPointsTeamB = findViewById(R.id.pointsTeamB);
        mFinalPointsTeamA = findViewById(R.id.finalPointsTeamA);
        mFinalPointsTeamB = findViewById(R.id.finalPointsTeamB);

        mPointsTeamA.setText("0");
        mPointsTeamB.setText("0");
        mFinalPointsTeamA.setText("0");
        mFinalPointsTeamB.setText("0");

        mButtonGoalTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 1;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButtonGoalTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 1;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mFinalButtonGoalTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalTeamAScore += 1;
                String finalTeamAScoreString = Integer.toString(finalTeamAScore);
                mFinalPointsTeamA.setText(finalTeamAScoreString);
            }
        });

        mFinalButtonGoalTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalTeamBScore += 1;
                String finalTeamBScoreString = Integer.toString(finalTeamBScore);
                mFinalPointsTeamB.setText(finalTeamBScoreString);
            }
        });

        mMinusPointTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore -= 1;
                if (teamAScore >= 0) {
                    String teamAScoreString = Integer.toString(teamAScore);
                    mPointsTeamA.setText(teamAScoreString);
                } else {
                    teamAScore = 0;
                    mPointsTeamA.setText("0");
                }

            }
        });

        mMinusPointTeamB.setOnClickListener(new View.OnClickListener() {
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

        mFinalMinusPointTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalTeamAScore -= 1;
                if (finalTeamAScore >= 0) {
                    String finalTeamAScoreString = Integer.toString(finalTeamAScore);
                    mFinalPointsTeamA.setText(finalTeamAScoreString);
                } else {
                    finalTeamAScore = 0;
                    mFinalPointsTeamA.setText("0");
                }

            }
        });

        mFinalMinusPointTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalTeamBScore -= 1;
                if (finalTeamBScore >= 0) {
                    String finalTeamBScoreString = Integer.toString(finalTeamBScore);
                    mFinalPointsTeamB.setText(finalTeamBScoreString);
                } else {
                    finalTeamBScore = 0;
                    mFinalPointsTeamB.setText("0");
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

        mResetButtonResetPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalTeamAScore = 0;
                finalTeamBScore = 0;
                String finalTeamAScoreString = Integer.toString(finalTeamAScore);
                String finalTeamBScoreString = Integer.toString(finalTeamBScore);
                mFinalPointsTeamA.setText(finalTeamAScoreString);
                mFinalPointsTeamB.setText(finalTeamBScoreString);
            }
        });


    }


}