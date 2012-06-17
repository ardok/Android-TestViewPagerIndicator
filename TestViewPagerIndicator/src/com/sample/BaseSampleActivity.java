package com.sample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;

public abstract class BaseSampleActivity extends FragmentActivity {
    FragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
}
