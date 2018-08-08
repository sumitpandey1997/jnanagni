package com.example.user.nevigation; /**
 * Created by user on 19-06-2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.nevigation.TabFragment;


/**
 * Created by user on 18-06-2018.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private String title[] = {"TECHNICAL", "NON-TECHNICAL", "GAME-ON","MEGA-EVENTS","CULTURAL","FUN-EVENTS"};

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
