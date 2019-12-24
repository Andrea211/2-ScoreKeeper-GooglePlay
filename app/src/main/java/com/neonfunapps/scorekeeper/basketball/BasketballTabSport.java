package com.neonfunapps.scorekeeper.basketball;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.neonfunapps.scorekeeper.R;

import java.util.Locale;

public class BasketballTabSport extends Fragment {

    // counting points
    private int teamAScore = 0;
    private int teamBScore = 0;
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
    private Button mButton1pointTeamA;
    private Button mButton2pointsTeamA;
    private Button mButton3pointsTeamA;
    private Button mButton1pointTeamB;
    private Button mButton2pointsTeamB;
    private Button mButton3pointsTeamB;
    private Button mMinus1pointTeamA;
    private Button mMinus2pointsTeamA;
    private Button mMinus3pointsTeamA;
    private Button mMinus1pointTeamB;
    private Button mMinus2pointsTeamB;
    private Button mMinus3pointsTeamB;
    private Button mButtonResetPoints;
    private TextView mPointsTeamA;
    private TextView mPointsTeamB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.sport_basketball_tabsport, container, false);

        mButton1pointTeamA = RootView.findViewById(R.id.button1pointTeamA);
        mButton2pointsTeamA = RootView.findViewById(R.id.button2pointsTeamA);
        mButton3pointsTeamA = RootView.findViewById(R.id.button3pointsTeamA);
        mButton1pointTeamB = RootView.findViewById(R.id.button1pointTeamB);
        mButton2pointsTeamB = RootView.findViewById(R.id.button2pointsTeamB);
        mButton3pointsTeamB = RootView.findViewById(R.id.button3pointsTeamB);
        mMinus1pointTeamA = RootView.findViewById(R.id.minus1pointTeamA);
        mMinus2pointsTeamA = RootView.findViewById(R.id.minus2pointsTeamA);
        mMinus3pointsTeamA = RootView.findViewById(R.id.minus3pointsTeamA);
        mMinus1pointTeamB = RootView.findViewById(R.id.minus1pointTeamB);
        mMinus2pointsTeamB = RootView.findViewById(R.id.minus2pointsTeamB);
        mMinus3pointsTeamB = RootView.findViewById(R.id.minus3PointsTeamB);
        mButtonResetPoints = RootView.findViewById(R.id.pointsReset);

        mPointsTeamA = RootView.findViewById(R.id.pointsTeamA);
        mPointsTeamB = RootView.findViewById(R.id.pointsTeamB);

        mPointsTeamA.setText("0");
        mPointsTeamB.setText("0");

        mButton1pointTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 1;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButton2pointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 2;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButton3pointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 3;
                String teamAScoreString = Integer.toString(teamAScore);
                mPointsTeamA.setText(teamAScoreString);
            }
        });

        mButton1pointTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 1;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mButton2pointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 2;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mButton3pointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 3;
                String teamBScoreString = Integer.toString(teamBScore);
                mPointsTeamB.setText(teamBScoreString);
            }
        });

        mMinus1pointTeamA.setOnClickListener(new View.OnClickListener() {
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

        mMinus2pointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore -= 2;
                if (teamAScore >= 0) {
                    String teamAScoreString = Integer.toString(teamAScore);
                    mPointsTeamA.setText(teamAScoreString);
                } else {
                    teamAScore = 0;
                    mPointsTeamA.setText("0");
                }

            }
        });

        mMinus3pointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore -= 3;
                if (teamAScore >= 0) {
                    String teamAScoreString = Integer.toString(teamAScore);
                    mPointsTeamA.setText(teamAScoreString);
                } else {
                    teamAScore = 0;
                    mPointsTeamA.setText("0");
                }

            }
        });

        mMinus1pointTeamB.setOnClickListener(new View.OnClickListener() {
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

        mMinus2pointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore -= 2;
                if (teamBScore >= 0) {
                    String teamBScoreString = Integer.toString(teamBScore);
                    mPointsTeamB.setText(teamBScoreString);
                } else {
                    teamBScore = 0;
                    mPointsTeamB.setText("0");
                }

            }
        });

        mMinus3pointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore -= 3;
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


        mEditTextInput = RootView.findViewById(R.id.edit_text_input);
        mTextViewCountDown = RootView.findViewById(R.id.text_view_countdown);

        mButtonSet = RootView.findViewById(R.id.button_set);
        mButtonStartPause = RootView.findViewById(R.id.button_start_pause);
        mButtonReset = RootView.findViewById(R.id.button_reset);


        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditTextInput.getText().toString();

                if (input.length() == 0) {
                    Toast.makeText(getActivity(), R.string.field_cant_be_empty, Toast.LENGTH_SHORT).show();
                } else if (input.equals("0")) {
                    Toast.makeText(getActivity(), R.string.enter_positive_number, Toast.LENGTH_SHORT).show();
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
        return RootView;

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

            Drawable img = getContext().getResources().getDrawable(R.drawable.ic_pause_black_24dp);
            mButtonStartPause.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);

            mButtonStartPause.setText(R.string.pause);
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
            mButtonSet.setVisibility(View.VISIBLE);

            Drawable img = getContext().getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp);
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
        View view = this.getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
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

        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);

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