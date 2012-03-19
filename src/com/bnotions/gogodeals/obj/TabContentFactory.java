package com.bnotions.gogodeals.obj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class TabContentFactory implements
		android.widget.TabHost.TabContentFactory {
	private Context context;
	
	public TabContentFactory(Context context) {
		this.context = context;
	}
	
	@Override
	public View createTabContent(String tag) {
		
		ImageView view = new ImageView(context);
		view.setMinimumWidth(0);
		view.setMinimumHeight(0);
		
		return view;
	}

}
