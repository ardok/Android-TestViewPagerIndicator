package com.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class FragmentAdapter extends FragmentPagerAdapter {
	private Fragment[] CONTENT;
	
	private int mCount;

    public FragmentAdapter(FragmentManager fm, Fragment[] frags) {
        super(fm);
        CONTENT = frags;
        mCount = CONTENT.length;
    }

    @Override
    public Fragment getItem(int position) {
        return CONTENT[position % mCount];
    }

    @Override
    public int getCount() {
        return mCount;
    }
}