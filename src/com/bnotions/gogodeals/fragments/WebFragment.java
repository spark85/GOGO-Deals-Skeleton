package com.bnotions.gogodeals.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.bnotions.gogodeals.R;
import com.bnotions.gogodeals.obj.MyWebViewClient;

public class WebFragment extends Fragment implements OnClickListener, OnEditorActionListener {

	private RelativeLayout view_web_container;
	private LinearLayout nav_bar_container;
	private WebView view_web;
	private boolean webview_available;
	private AutoCompleteTextView txtbox_nav_search;
	private ImageButton btn_nav_forward;
	private ImageButton btn_nav_back;
	private MyWebViewClient webview_client;
	private String url;

	public static WebFragment newInstance() {
		return new WebFragment();
	}
	
	public WebFragment() {
		super();
	}

	/**
	 * Called to instantiate the view. Creates and returns the WebView.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (view_web != null) {
			view_web.destroy();
		}

		view_web_container =  (RelativeLayout) inflater.inflate(R.layout.fragment_webviewer, null);
		nav_bar_container = (LinearLayout) view_web_container.findViewById(R.id.nav_bar_container);
		view_web = (WebView) view_web_container.findViewById(R.id.web_view);
		
		btn_nav_forward = (ImageButton) view_web_container.findViewById(R.id.btn_nav_forward);
		btn_nav_back = (ImageButton) view_web_container.findViewById(R.id.btn_nav_back);
		txtbox_nav_search = (AutoCompleteTextView) view_web_container.findViewById(R.id.txtbox_nav_search);

		btn_nav_forward.setOnClickListener(this);
		btn_nav_back.setOnClickListener(this);
		txtbox_nav_search.setOnEditorActionListener(this);
		
		view_web.getSettings().setJavaScriptEnabled(true);
		webview_client = new MyWebViewClient(this);
		view_web.setWebViewClient(webview_client);
	
		webview_available = true;
		return view_web_container;
	}

	/**
	 * Convenience method for loading a url. Will fail if {@link View} is not initialised (but won't throw an {@link Exception})
	 * @param url
	 */
	public void loadUrl(String url) {
		this.url = url;
		webview_client.shouldOverrideUrlLoading(view_web, url);
		
	}

	
	/**
	 * Called when the WebView has been detached from the fragment.
	 * The WebView is no longer available after this time.
	 */
	@Override
	public void onDestroyView() {
		webview_available = false;
		super.onDestroyView();
	}

	/**
	 * Called when the fragment is no longer in use. Destroys the internal state of the WebView.
	 */
	@Override
	public void onDestroy() {
		if (view_web != null) {
			view_web.destroy();
			view_web = null;
		}
		super.onDestroy();
	}

	/**
	 * Gets the WebView.
	 */
	public WebView getWebView() {
		Log.d("WebFragment", "webview_available in getWebView= " + webview_available);
		return webview_available ? view_web : null;
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case(R.id.btn_nav_back):
			try {
				view_web.goBack();
			} catch (Exception e) {
				Log.d("WebFragment", "go back caused " + e.toString());
			} 

		case(R.id.btn_nav_forward):
			try {
				view_web.goForward();
			} catch (Exception e) {
				Log.d("WebFragment", "go forward caused " + e.toString());
			} 
		}
	}

	@Override
	public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
		String txt_entered;
		//Per API if KeyEvent event == enter key, will return event, otherwise null
		//http://developer.android.com/reference/android/widget/TextView.OnEditorActionListener.html
		
		if (event != null) {
				txt_entered = (String) view.getText();
				Log.d("WebFragment", "onEditorAction called, txt_entered= " + txt_entered);
			}
		
		return true;
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		return this.url;
	}
	
	public void setUrl(String url) {
		
		Log.d("WebFragment", "new url= " + url);
		
		this.url = url;
	}
	

}
