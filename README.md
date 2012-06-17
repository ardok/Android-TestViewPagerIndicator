Android-TestViewPagerIndicator
==============================

This is a simple Android project to test Jake Wharton's ViewPagerIndicator

This is where I got the library from: http://viewpagerindicator.com/

I just added the library using import File System on my project

In this simple Android project, I added some fade in and fade out animations on the CirclePageIndicator. The indicator will fade in when user switches page (scrolling) and fade out when user is idle (no scrolling).
I also show an example to put Parcelable into a Bundle so that I can save a fragment's state.

Clarification about FragmentPagerAdapter vs PagerAdapter : http://stackoverflow.com/questions/8425961/diference-fragmentpageradapter-and-pageradapter

I'm using FragmentPagerAdapter in this simple project even though I don't have any code that is going to be reused.