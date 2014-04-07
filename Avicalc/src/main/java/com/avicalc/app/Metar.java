package com.avicalc.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Metar extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metar);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        EditText metarOutput2 = (EditText) findViewById(R.id.metarInput);
        metarOutput2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    getMetar();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void goMetar(View v) {
        getMetar();
    }
    public void getMetar() {
        EditText metarInput1 = (EditText)findViewById(R.id.metarInput);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        WebView myWebView2 = (WebView) findViewById(R.id.webView2);

        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(metarInput1.getWindowToken(), 0);

        String icao = metarInput1.getText().toString().toUpperCase();
        String urlMetar = "http://weather.noaa.gov/pub/data/observations/metar/stations/" + icao + ".TXT";
        String urlTaf = "http://weather.noaa.gov/pub/data/forecasts/taf/stations/" + icao + ".TXT";

        myWebView.loadUrl(urlMetar);
        myWebView2.loadUrl(urlTaf);

        myWebView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        myWebView2.setBackgroundColor(Color.parseColor("#EEEEEE"));

        myWebView.setVerticalScrollBarEnabled(false);
        myWebView2.setVerticalScrollBarEnabled(false);

        }
}
