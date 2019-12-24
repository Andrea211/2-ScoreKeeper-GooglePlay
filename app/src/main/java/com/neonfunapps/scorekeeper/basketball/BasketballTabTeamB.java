package com.neonfunapps.scorekeeper.basketball;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.neonfunapps.scorekeeper.R;

public class BasketballTabTeamB extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sport_basketball_tabteamb, container, false);
    }
}
