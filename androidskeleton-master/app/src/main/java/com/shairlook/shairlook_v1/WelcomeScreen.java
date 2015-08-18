package com.shairlook.shairlook_v1;

/**
 * Created by kristian on 19/06/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.ImageButton;

public class WelcomeScreen extends Activity {

    private WebView mWebView;
    ImageButton completeprofile;
    ImageButton gotoportfolio;
    ImageButton findfriends;
    ImageButton readnews;
    private static final String TAG = "WelcomeScreen";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        completeprofile = (ImageButton) findViewById(R.id.completeprofile);
        gotoportfolio = (ImageButton) findViewById(R.id.gotoportfolio);
        findfriends = (ImageButton) findViewById(R.id.findfriends);
        readnews = (ImageButton) findViewById(R.id.readnews);

        completeprofile.setOnClickListener(new View.OnClickListener() {

        //@Override
        public void onClick(View view) {
                Intent i = new Intent(WelcomeScreen.this, SplashScreen.class);
                startActivity(i);
            }
        });

        gotoportfolio.setOnClickListener(new View.OnClickListener() {

             //@Override
             public void onClick(View view) {
                 Intent i = new Intent(WelcomeScreen.this, LoginActivity.class);
                 startActivity(i);
             }
        });

        findfriends.setOnClickListener(new View.OnClickListener() {

             //@Override
             public void onClick(View view) {
                 Intent i = new Intent(WelcomeScreen.this, MainActivity.class);
                 startActivity(i);
             }
        });

        readnews.setOnClickListener(new View.OnClickListener() {

             //@Override
             public void onClick(View view) {
                 Log.d(TAG, "Logout");
                 logout(true);
                 //Intent i = new Intent(WelcomeScreen.this, SplashScreen.class);
                 //startActivity(i);
             }
        });
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
        mWebView.setWebChromeClient(new WebChromeClient() {
        });
        String html = "";
        html += "<html><body>";
        html += "<iframe width=\"740\" height=\"480\" src=\"http://www.youtube.com/embed/ijUwo92_kaU?rel=0\" frameborder=\"0\" allowfullscreen></iframe>";
        html += "</body></html>";

        mWebView.loadData(html, "text/html", null);
    }
    private void logout(boolean revoke) {
        Log.d(TAG, "Logout with one parameter");
        Intent returnIntent = new Intent();
        if(revoke == true) {
            returnIntent.putExtra(AndroidSkeletonUtils.REVOKE_KEY, true);
        }
        setResult(RESULT_OK,returnIntent);
        finish();
    }
    public void logout(){
        Log.d(TAG, "Logout");
        logout(false);
    }


}
