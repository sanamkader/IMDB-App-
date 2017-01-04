package com.android.assignment.acadgild.anup.imdbproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.NowPlaying;
import layout.TopRated;
import layout.Upcoming;


class PageAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new NowPlaying();
            case 1:
                return new TopRated();
            case 2:
                return new Upcoming();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Now Playing";
            case 1:
                return "Top Rated";
            case 2:
                return "Upcoming";
        }
        return null;
    }
}

