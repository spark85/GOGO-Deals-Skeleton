package com.bnotions.gogodeals.obj;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bnotions.gogodeals.fragments.WebFragment;

public class MyWebViewClient extends WebViewClient {

	private com.bnotions.gogodeals.fragments.WebFragment web_fragment; 
	
	/* (non-Javadoc)
	 * @see android.webkit.WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String)
	 */
	public MyWebViewClient(WebFragment web_fragment) {
		this.web_fragment = web_fragment;
	}


	
	
	/* (non-Javadoc)
	 * @see android.webkit.WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String)
	 */
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	}




	/* (non-Javadoc)
	 * @see android.webkit.WebViewClient#onPageStarted(android.webkit.WebView, java.lang.String, android.graphics.Bitmap)
	 */
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		Log.i("MyWebViewClient", "onPageStarted was called");
		web_fragment.setUrl(url);
		
		// TODO Auto-generated method stub
		super.onPageStarted(view, url, favicon);
	}
	
}
