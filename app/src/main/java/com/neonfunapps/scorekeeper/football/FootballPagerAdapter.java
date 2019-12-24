package com.neonfunapps.scorekeeper.football;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FootballPagerAdapter extends FragmentStatePagerAdapter {
    private final int mNumOfTabs;

    public FootballPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FootballTabSport();
            case 1:
                return new FootballTabTeamA();
            case 2:
                return new FootballTabTeamB();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}