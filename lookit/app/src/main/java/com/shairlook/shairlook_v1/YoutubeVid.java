package com.shairlook.shairlook_v1;

/**
 * Created by kristian on 19/06/2015.
 */

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

public class YoutubeVid extends Activity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        initWebView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            WebView.class.getMethod("onResume").invoke(mWebView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            WebView.class.getMethod("onPause").invoke(mWebView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initWebView() {
        mWebView = (WebView) findViewById(R.id.webView);

        // WebView???
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT > 7) {
            mWebView.getSettings().setPluginState(PluginState.ON);

        }
        mWebView.setWebChromeClient(new WebChromeClient(){
        });
        String html = "";
        html += "<html><body>";
        html += "<iframe width=\"720\" height=\"480\" src=\"http://www.youtube.com/embed/ijUwo92_kaU?rel=0\" frameborder=\"0\" allowfullscreen></iframe>";
        html += "</body></html>";

        mWebView.loadData(html, "text/html", null);
    }

}

