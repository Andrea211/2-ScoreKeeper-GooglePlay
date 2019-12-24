package com.neonfunapps.scorekeeper.basketball;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class BasketballPagerAdapter extends FragmentStatePagerAdapter {
    private final int mNumOfTabs;

    public BasketballPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BasketballTabSport();
            case 1:
                return new BasketballTabTeamA();
            case 2:
                return new BasketballTabTeamB();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}