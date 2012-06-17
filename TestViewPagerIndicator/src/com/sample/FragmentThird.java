package com.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Our third view
 * @author ardokusuma
 *
 */
public class FragmentThird extends Fragment {
	private View v;
	private Button b;
	
	public static FragmentThird newInstance() {
		FragmentThird fragment = new FragmentThird();
        return fragment;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_third, container, false);
        b = (Button) v.findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "You have clicked the button!", Toast.LENGTH_SHORT).show();
				((SampleActivity) getActivity()).mPager.setCurrentItem(0, true);
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
