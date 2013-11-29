package com.penrillian.colinsapp.test;

import com.penrillian.colinsapp.R;
import com.penrillian.colinsapp.DisplayMessageActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class DisplayMessageActivityTest extends ActivityInstrumentationTestCase2<DisplayMessageActivity> {
	
	private DisplayMessageActivity mDisplayActivity;
	private TextView mTextView;
	
	public DisplayMessageActivityTest() {
		super(DisplayMessageActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		mDisplayActivity = getActivity();
		mTextView = (TextView) mDisplayActivity.findViewById(R.id.default_text);
	}
	
	public void testPreconditions() {
		assertNotNull("mDisplayActivity is null", mDisplayActivity);
		assertNotNull("mTextView is null", mTextView);
	}
	
	public void testDisplayMessageActivity_buttonText() {
		final String expected = mDisplayActivity.getString(R.string.hello_world);
		final String actual = mTextView.getText().toString();
		assertEquals("mTextView contains wrong text", expected, actual);
	}
	
}
