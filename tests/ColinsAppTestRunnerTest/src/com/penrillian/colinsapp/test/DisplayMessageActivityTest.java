package com.penrillian.colinsapp.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.penrillian.colinsapp.DisplayMessageActivity;
import com.penrillian.colinsapp.R;

public class DisplayMessageActivityTest extends ActivityInstrumentationTestCase2<DisplayMessageActivity> {
	
	private DisplayMessageActivity mDisplayActivity;
	private static final int TIMEOUT_IN_MS = 5000;
	private static final String TEST_MESSAGE = "Message";
	
	public DisplayMessageActivityTest() {
		super(DisplayMessageActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		mDisplayActivity = getActivity();
	}
	
	public void testPreconditions() {
		assertNotNull("mDisplayActivity is null", mDisplayActivity);
	}
	
	public void testDisplayMessageActivity_sendingTextPrintsSentText() {
		final Button sendButton = (Button) mDisplayActivity.findViewById(R.id.send_button);
		final EditText editTextField = (EditText) mDisplayActivity.findViewById(R.id.edit_message);
		
		Instrumentation.ActivityMonitor sendButtonActivityMonitor = getInstrumentation().addMonitor(DisplayMessageActivity.class.getName(), null, false);
		
		getInstrumentation().runOnMainSync(new Runnable() {
			@Override
			public void run() {
				editTextField.requestFocus();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		getInstrumentation().sendStringSync(TEST_MESSAGE);
		getInstrumentation().waitForIdleSync();
		
		TouchUtils.clickView(this, sendButton);
		
		DisplayMessageActivity displayActivity = (DisplayMessageActivity) sendButtonActivityMonitor.waitForActivityWithTimeout(TIMEOUT_IN_MS);
		
		assertNotNull("DisplayMessageActivity is null", displayActivity);
		assertEquals("Monitor for displayActivity has not been called", 1, sendButtonActivityMonitor.getHits());
		assertEquals("Activity is of wrong type", DisplayMessageActivity.class, displayActivity.getClass());
		
		final TextView sentMessage = (TextView) displayActivity.findViewById(R.id.default_text);
		assertNotNull(sentMessage);
		assertEquals("Wrong message received", TEST_MESSAGE, sentMessage.getText().toString());
	}
	
}
