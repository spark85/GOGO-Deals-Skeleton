package com.bnotions.gogodeals.obj;

import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class TabInfo {

    public final String tag;
    public final Class<?> clss;
    public final Bundle args;

    public TabInfo(String _tag, Class<?> _class, Bundle _args) {
        tag = _tag;
        clss = _class;
        args = _args;
    }

	
	
}
