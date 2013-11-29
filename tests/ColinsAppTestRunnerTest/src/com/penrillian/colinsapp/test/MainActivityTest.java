package com.penrillian.colinsapp.test;

import android.test.ActivityInstrumentationTestCase2;

import com.penrillian.colinsapp.MainActivity;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private MainActivity mMainActivity;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		mMainActivity = getActivity();
	}

}
