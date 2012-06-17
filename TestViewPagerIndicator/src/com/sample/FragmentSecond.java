package com.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Our second view
 * @author ardokusuma
 *
 */
public class FragmentSecond extends Fragment {
	private View v;
	private Button b;
	private EditText et;
	
	public static FragmentSecond newInstance() {
		FragmentSecond fragment = new FragmentSecond();
        return fragment;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second, container, false);
        et = (EditText) v.findViewById(R.id.editText1);
        b = (Button) v.findViewById(R.id.showToast);
        b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String text = et.getText().toString();
				if (text.length() != 0) {
					et.setText("");
					Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
					
					// We need to "send" the text that the user entered to the first page
					// Go to FragmentFirst.java file and check out what this method does :)
					((FragmentFirst) SampleActivity.CONTENT[0]).sendText(text);
				}
			}
		});
        
        // You can add more stuff here
        // Keep in mind that with FragmentPagerAdapter, the pages that are not adjacent will be recreated
        //   i.e. onCreateView will be called again.
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
