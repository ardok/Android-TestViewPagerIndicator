package com.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;

import com.viewpagerindicator.CirclePageIndicator;

public class SampleActivity extends BaseSampleActivity implements ViewPager.OnPageChangeListener {
	public static Fragment[] CONTENT = new Fragment[] { FragmentFirst.newInstance(), FragmentSecond.newInstance(), 
		FragmentThird.newInstance() };
	private CirclePageIndicator cpi;
	Animation fadeIn, fadeOut;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Initialize the adapter with our fragments
        mCircleAdapter = new FragmentAdapter(getSupportFragmentManager(), CONTENT);
        
        // Initialize our ViewPager
        mPager = (ViewPager) this.findViewById(R.id.pager);
        mPager.setAdapter(mCircleAdapter);
        mPager.setOnPageChangeListener(this);
        
        // Initialize the simple CirclePageIndicator by Jake Wharton
        mCircleIndicator = (CirclePageIndicator) this.findViewById(R.id.circleIndicator);
        mCircleIndicator.setViewPager(mPager);
        mCircleIndicator.setOnPageChangeListener(this);
        
        // Since mIndicator is a PageIndicator, we need to store our indicator as a View, i.e.
        // CirclePageIndicator, so that we can add the cool animation :)
        cpi = (CirclePageIndicator) this.findViewById(R.id.circleIndicator);
       	
        // Initialize the fadeIn animation
        fadeIn = new AlphaAnimation(0, 1);
       	fadeIn.setInterpolator(new DecelerateInterpolator());
		fadeIn.setDuration(1000);
		fadeIn.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				cpi.setVisibility(View.VISIBLE);
			}
		});
		
		// Initialize the fadeOut animation
		fadeOut = new AlphaAnimation(1, 0);
		fadeOut.setInterpolator(new AccelerateInterpolator());
		fadeOut.setStartOffset(1000);
		fadeOut.setDuration(1000);
		fadeOut.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				cpi.setVisibility(View.GONE);
			}
		});
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	// Always set the current page to the middle one
    	mPager.setCurrentItem(1, false);
    	cpi.startAnimation(fadeOut);
    }
    
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// Oh yeah...this is where the magic happens
		if (arg0 == ViewPager.SCROLL_STATE_DRAGGING) {
			// Show the indicator while we are scrolling
			if (fadeOut.hasEnded()) cpi.startAnimation(fadeIn);
			else fadeOut.cancel();
		} else if (arg0 == ViewPager.SCROLL_STATE_IDLE) {
			// Hide the indicator if we are not scrolling or idle
			cpi.startAnimation(fadeOut);
		}
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {}

	@Override
	public void onPageSelected(int arg0) {}
}