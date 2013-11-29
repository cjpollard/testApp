package com.penrillian.colinsapp.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.penrillian.colinsapp.MainActivity;
import com.penrillian.colinsapp.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private MainActivity mMainActivity;
	private Button mSendButton;
	private TextView mTextView;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		
		setActivityInitialTouchMode(true);
		
		mMainActivity = getActivity();
		mSendButton = (Button) mMainActivity.findViewById(R.id.send_button);
		mTextView = (TextView) mMainActivity.findViewById(R.id.default_text);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		
	}
	
	public void testPreconditions() {
		assertNotNull("mMainActivity is null", mMainActivity);
		assertNotNull("mSendButton is null", mSendButton);
		assertNotNull("mTextView is null", mTextView);
	}
	
	public void testSendButton_layout() {
		final View decorView = mMainActivity.getWindow().getDecorView();
		
		ViewAsserts.assertOnScreen(decorView, mSendButton);
		
		final ViewGroup.LayoutParams layoutParams = mSendButton.getLayoutParams();
		
		assertNotNull(layoutParams);
		assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
		assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	}
	
	@MediumTest
	public void testSendButton_clickButtonDoesStuff() {
		String expectedTextOnBlankTextField = "";
		TouchUtils.clickView(this, mSendButton);
		assertTrue(View.VISIBLE == mTextView.getVisibility());
		assertEquals(expectedTextOnBlankTextField, mTextView.getText());
	}

}
