package com.bnotions.gogodeals.fragments;


import com.bnotions.gogodeals.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;




public class FormFragment extends Fragment implements OnClickListener{
	
	private View view_container;
	private ViewFlipper view_flipper;
	private Button btn_submit;
	private Button btn_back_to_form;
	private OnClickListener listener;
	
	
	public static FormFragment newInstance(int num) {
		FormFragment form_fragment = new FormFragment();
		
		Bundle args = new Bundle();
		args.putInt("num", num);
		form_fragment.setArguments(args);
		
		return form_fragment;
	}
	
	public FormFragment() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
	
		super.onCreate(savedInstanceState);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 view_container = inflater.inflate(R.layout.fragment_form_field, null);
		 
    	 view_flipper = (ViewFlipper) view_container.findViewById(R.id.view_flipper);
		 btn_submit = (Button) view_flipper.findViewById(R.id.btn_submit);
		 btn_back_to_form = (Button) view_flipper.findViewById(R.id.btn_back_to_form);
		 
		 btn_submit.setOnClickListener(this);
		 
		 view_flipper.setDisplayedChild(0);
		  		 
		 return view_container;
	}

	public void setOnClickListener(OnClickListener listener) {
		
		this.listener = listener;
	}
	
	public void flipScreen() {
		
		if (view_flipper.getDisplayedChild() == 0) {
			view_flipper.setDisplayedChild(1);
		} else {
			view_flipper.setDisplayedChild(0);
		}
		
	}

	//Listens for: button in FormFragment
		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case (R.id.btn_submit): 
				flipScreen();
			}
		}
}
