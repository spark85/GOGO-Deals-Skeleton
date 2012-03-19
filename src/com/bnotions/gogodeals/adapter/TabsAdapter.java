package com.bnotions.gogodeals.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.bnotions.gogodeals.obj.TabContentFactory;
import com.bnotions.gogodeals.obj.TabInfo;

public class TabsAdapter extends FragmentPagerAdapter 
			implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener{

	private final Context context;
    private final TabHost tab_host;
    private final ViewPager view_pager;
    private final ArrayList<TabInfo> tabs= new ArrayList<TabInfo>();
	private FragmentManager fragment_manager;
    
	public TabsAdapter(FragmentActivity activity, TabHost tabHost, ViewPager pager) {
		super(activity.getSupportFragmentManager());
		
		fragment_manager = activity.getSupportFragmentManager();
		
		context = activity;
		tab_host = tabHost;
		view_pager = pager;
		
		tab_host.setOnTabChangedListener(this);
		view_pager.setAdapter(this);
		view_pager.setOnPageChangeListener(this);
		
	}

	public void addTab(TabHost.TabSpec tabSpec, Class<?> frag_class, Bundle args) {
		tabSpec.setContent(new TabContentFactory(context));
		String tag = tabSpec.getTag();
		
		TabInfo info = new TabInfo(tag, frag_class, args);
		tabs.add(info);
		tab_host.addTab(tabSpec);
		notifyDataSetChanged();
		
	}
	
	@Override
	public Fragment getItem(int position) {
	
		TabInfo info = tabs.get(position);
		Fragment temp = Fragment.instantiate(context, info.clss.getName());
		
	
		return temp;
		}

	@Override
	public int getCount() {
		
	
		return tabs.size();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		
		//This block of code prevents the tab widget from taking the focus away from the viewpager
		TabWidget widget = tab_host.getTabWidget();
		int oldFocusability = widget.getDescendantFocusability();
		widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
		
		tab_host.setCurrentTab(position);
		widget.setDescendantFocusability(oldFocusability);
		
	}

	@Override
	public void onTabChanged(String tabId) {
		
		int position = tab_host.getCurrentTab();
		view_pager.setCurrentItem(position);
	}

}
