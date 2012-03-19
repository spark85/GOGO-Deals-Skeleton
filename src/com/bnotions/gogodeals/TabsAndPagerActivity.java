package com.bnotions.gogodeals;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBar;
import android.support.v4.app.ActionBar.Tab;
import android.support.v4.app.ActionBar.TabListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.ViewFlipper;

import com.bnotions.gogodeals.adapter.TabsAdapter;
import com.bnotions.gogodeals.fragments.FormFragment;
import com.bnotions.gogodeals.fragments.WebFragment;
import com.bnotions.gogodeals.obj.MultiDirectionSlidingDrawer;

import com.bnotions.gogodeals.R;

public class TabsAndPagerActivity extends FragmentActivity implements OnClickListener, TabListener {

	private FragmentManager fragment_manager;
	private WebFragment web_fragment;
	private ViewPager pager;
	private ViewFlipper flipper_drawer;

	private Button btn_close;
	private ImageButton imgbtn_handle;
	private MultiDirectionSlidingDrawer drawer;

	private ImageButton imgbtn_left_filter;
	private ImageButton imgbtn_middle_filter;
	private ImageButton imgbtn_right_filter;

	private TabHost tab_host;
	private ActionBar bar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    
		requestWindowFeature( Window.FEATURE_NO_TITLE );
		setContentView(R.layout.activity_main);

		init();


	}
	private void init() {	

		setUpSlidingDrawer();
		setUpTabHost();
		setUpActionBar();

	}

	private void setUpSlidingDrawer() {

		

		drawer = (MultiDirectionSlidingDrawer) findViewById(R.id.drawer);
		View content = drawer.findViewById(R.id.content);
		
		imgbtn_left_filter = (ImageButton) findViewById(R.id.imgbtn_left_filter);
		imgbtn_middle_filter = (ImageButton) findViewById(R.id.imgbtn_middle_filter);
		imgbtn_right_filter = (ImageButton) findViewById(R.id.imgbtn_right_filter);

		imgbtn_left_filter.setOnClickListener(this);
		imgbtn_middle_filter.setOnClickListener(this);
		imgbtn_right_filter.setOnClickListener(this);
		
		View handler = findViewById(R.id.handle);
		
		flipper_drawer = (ViewFlipper) content.findViewById(R.id.view_flipper_drawer);
		flipper_drawer = (ViewFlipper) drawer.getChildAt(0);
					
		flipper_drawer.setOnClickListener(this);
		imgbtn_handle.setOnClickListener(this);

	}

	private void setUpTabHost() {

		TabHost tab_host = (TabHost) findViewById(android.R.id.tabhost);
		tab_host.setup();

		pager = (ViewPager) findViewById(R.id.pager);

		TabsAdapter adapter = new TabsAdapter(this, tab_host, pager);

		TabSpec first = tab_host.newTabSpec("first");
		first.setIndicator("first");

		adapter.addTab(tab_host.newTabSpec("web_fragment").setIndicator("Browser"),
				WebFragment.class, null);
		adapter.addTab(tab_host.newTabSpec("form_fragment").setIndicator("Form"),
				FormFragment.class, null);

	}


	public void onContentChanged() {
		super.onContentChanged();
		//		button_close = (Button) findViewById( R.id.button_close );
		imgbtn_handle = (ImageButton) findViewById(R.id.handle);
		drawer = (MultiDirectionSlidingDrawer) findViewById(R.id.drawer);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.handle: 
			drawer.animateOpen();
			break;
		case R.id.imgbtn_left_filter:
			drawer.animateOpen();
			flipper_drawer.setDisplayedChild(0);
			break;
		case R.id.imgbtn_middle_filter:
			drawer.animateOpen();
			flipper_drawer.setDisplayedChild(1);
			break;
		case R.id.imgbtn_right_filter:
			drawer.animateOpen();
			flipper_drawer.setDisplayedChild(2);
			break;
		}
	}
	private void setUpActionBar() {
		
	    bar = getSupportActionBar();
        
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayUseLogoEnabled(true);
        
        bar.setNavigationMode(android.support.v4.app.ActionBar.NAVIGATION_MODE_TABS);
        

	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}