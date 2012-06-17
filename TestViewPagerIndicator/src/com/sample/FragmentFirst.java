package com.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This is pretty much our first page view
 * @author ardokusuma
 *
 */
public class FragmentFirst extends Fragment {
	private static final String KEY_STRING_TEXT_ENTERED = "FragmentFirst:StringTextEntered";
	private static final String KEY_PARCELABLE_TEXT_ENTERED = "FragmentFirst:ParcelableTextEntered";
	
	private String textEntered;
	private Message message;
	
	private View v;
	private TextView fromStringTV, fromParcelableTV;
	
	public FragmentFirst() {
		textEntered = "";
		message = new Message();
	}
	
	/**
	 * Creating a new instance of FragmentFirst
	 * @return FragmentFirst fragment
	 */
	public static FragmentFirst newInstance() {
		FragmentFirst fragment = new FragmentFirst();
        return fragment;
	}
	
	/**
	 * This is to set the variable textEntered to the text that user puts in
	 * from page 3. Will also set the text views to show the text.
	 * @param text String to be sent or shown
	 */
	public void sendText(String text) {
		this.textEntered = text;
		setFromStringTextView(text);
		setFromParcelableTextView(text);
	}
	
	/**
	 * To set fromStringTV
	 * @param text String to be shown
	 */
	public void setFromStringTextView(String text) {
		if (text != null) fromStringTV.setText(text);
	}
	
	/**
	 * To set fromParcelableTV
	 * @param text String to be shown
	 */
	public void setFromParcelableTextView(String text) {
		if (text != null) fromParcelableTV.setText(text);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (savedInstanceState != null) {
        	if (savedInstanceState.containsKey(KEY_STRING_TEXT_ENTERED)) {
        		textEntered = savedInstanceState.getString(KEY_STRING_TEXT_ENTERED);
        	}
        	if (savedInstanceState.containsKey(KEY_PARCELABLE_TEXT_ENTERED)) {
        		message = (Message) savedInstanceState.getParcelable(KEY_PARCELABLE_TEXT_ENTERED);
        	}
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_first, container, false);
        fromStringTV = (TextView) v.findViewById(R.id.fromStringTextView);
        fromParcelableTV = (TextView) v.findViewById(R.id.fromParcelableTextView);
        
        if (textEntered != null && textEntered.length() != 0) {
        	fromStringTV.setText(textEntered);
        }
        
        if (message != null && message.getMessage().length() != 0) {
        	fromParcelableTV.setText(message.getMessage());
        }
        
        // You can add more stuff here
        // Keep in mind that with FragmentPagerAdapter, the pages that are not adjacent will be recreated
        //   i.e. onCreateView will be called again.
        return v;    	
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_STRING_TEXT_ENTERED, textEntered);
        outState.putParcelable(KEY_PARCELABLE_TEXT_ENTERED, new Message(textEntered));
    }
}
