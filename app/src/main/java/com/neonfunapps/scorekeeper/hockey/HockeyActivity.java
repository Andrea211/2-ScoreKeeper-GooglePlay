package com.neonfunapps.scorekeeper.hockey;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.neonfunapps.scorekeeper.R;

import java.util.Locale;

public class HockeyActivity extends AppCompatActivity {

    // timer
    private EditText mEditTextInput;
    private TextView mTextViewCountDown;
    private Button mButtonSet;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mStartTimeInMillis;
    private long mTimeLeftInMillis;
    private long mEndTime;

    // counting points
    private int teamAScore = 0;
    private int teamBScore = 0;
    private Button mButtonGoalTeamA;
    private Button mButtonGoalTeamB;
    private Button mMinusPointTeamA;
    private Button mMinusPointTeamB;
    private Button mButtonResetPoints;
    private TextView mPointsTeamA;
    private TextView mPointsTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_hockey_activity);

        Toolbar mToolbar = findViewById(R.id.hockey_toolbar);
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
        mButtonResetPoints = findViewById(R.id.goalsReset);

        mPointsTeamA = findViewById(R.id.pointsTeamA);
        mPointsTeamB = findViewById(R.id.pointsTeamB);

        mPointsTeamA.setText("0");
        mPointsTeamB.setText("0");

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


        // TIMER


        mEditTextInput = findViewById(R.id.edit_text_input);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonSet = findViewById(R.id.button_set);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);


        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditTextInput.getText().toString();

                if (input.length() == 0) {
                    Toast.makeText(HockeyActivity.this, R.string.field_cant_be_empty, Toast.LENGTH_SHORT).show();
                } else if (input.equals("0")) {
                    Toast.makeText(HockeyActivity.this, R.string.enter_positive_number, Toast.LENGTH_SHORT).show();
                } else {
                    long millisInput = Long.parseLong(input) * 60000;
                    setTime(millisInput);
                }

                mEditTextInput.setText("");
            }
        });

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

    }


    private void setTime(long milliseconds) {
        mStartTimeInMillis = milliseconds;
        resetTimer();
        closeKeyboard();
    }

    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateWatchInterface();
            }
        }.start();

        mTimerRunning = true;
        updateWatchInterface();
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();
    }

    private void resetTimer() {
        mTimeLeftInMillis = mStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();
    }

    private void updateCountDownText() {
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void updateWatchInterface() {
        if (mTimerRunning) {
            mEditTextInput.setVisibility(View.INVISIBLE);
            mButtonSet.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);

            Drawable img = HockeyActivity.this.getResources().getDrawable(R.drawable.ic_pause_black_24dp);
            mButtonStartPause.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);

            mButtonStartPause.setText(R.string.pause);
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
            mButtonSet.setVisibility(View.VISIBLE);

            Drawable img = HockeyActivity.this.getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp);
            mButtonStartPause.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);

            mButtonStartPause.setText(R.string.start);

            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < mStartTimeInMillis) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void closeKeyboard() {
        View view = HockeyActivity.this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) HockeyActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        SharedPreferences prefs = HockeyActivity.this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("startTimeInMillis", mStartTimeInMillis);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences prefs = HockeyActivity.this.getSharedPreferences("prefs", Context.MODE_PRIVATE);

        mStartTimeInMillis = prefs.getLong("startTimeInMillis", 600000);
        mTimeLeftInMillis = prefs.getLong("millisLeft", mStartTimeInMillis);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateWatchInterface();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateWatchInterface();
            } else {
                startTimer();
            }
        }
    }
}