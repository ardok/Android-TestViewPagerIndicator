package com.sample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;

public abstract class BaseSampleActivity extends FragmentActivity {
    FragmentAdapter mCircleAdapter;
    ViewPager mPager;
    PageIndicator mCircleIndicator;
}
