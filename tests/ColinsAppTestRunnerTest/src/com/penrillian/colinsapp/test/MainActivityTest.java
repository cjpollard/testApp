package com.penrillian.colinsapp.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.penrillian.colinsapp.MainActivity;
import com.penrillian.colinsapp.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private MainActivity mMainActivity;
	private Button mSendButton;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		mMainActivity = getActivity();
		mSendButton = (Button) mMainActivity.findViewById(R.id.send_button);
	}
	
	public void testPreconditions() {
		assertNotNull("mMainActivity is null", mMainActivity);
		assertNotNull("mSendButton is null", mSendButton);
	}
	
	public void testSendButton_layout() {
		final View decorView = mMainActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mSendButton);
		
		final ViewGroup.LayoutParams layoutParams = mSendButton.getLayoutParams();
		
		assertNotNull(layoutParams);
		assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
		assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}

}
