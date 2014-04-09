package com.avicalc.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
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

public class Navcalc extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navcalc);

        EditText long_deg = (EditText)findViewById(R.id.long_deg);
        EditText long_min = (EditText)findViewById(R.id.long_min);
        EditText time_hrs = (EditText)findViewById(R.id.time_hrs);
        EditText time_min = (EditText)findViewById(R.id.time_min);
        EditText time_sec = (EditText)findViewById(R.id.time_sec);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        long_deg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                longtimeCalc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        long_min.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                longtimeCalc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });
        time_hrs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                longtimeCalc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        time_min.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                longtimeCalc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        time_sec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                longtimeCalc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
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
    public void longtimeCalc() {
        EditText long_deg = (EditText)findViewById(R.id.long_deg);
        EditText long_min = (EditText)findViewById(R.id.long_min);
        EditText time_hrs = (EditText)findViewById(R.id.time_hrs);
        EditText time_min = (EditText)findViewById(R.id.time_min);
        EditText time_sec = (EditText)findViewById(R.id.time_sec);

        String str1 = long_deg.getText().toString();
        String str2 = long_min.getText().toString();
        String str3 = time_hrs.getText().toString();
        String str4 = time_min.getText().toString();
        String str5 = time_sec.getText().toString();

        double longitude;
        double time;
        double longDeg;
        double longMin;
        double timeHrs;
        double timeMin;
        double timeSec;

        if(str1.equals("")) {
                longDeg = 0;
            } else {
                longDeg = Double.parseDouble(long_deg.getText().toString());
        }
        if(str2.equals("")) {
                longMin = 0;
            } else {
                longMin = Double.parseDouble(long_min.getText().toString());
        }
        if(str3.equals("")) {
                timeHrs = 0;
             } else {
                 timeHrs = Double.parseDouble(time_hrs.getText().toString());
        }
        if(str4.equals("")) {
                timeMin = 0;
            } else {
                timeMin = Double.parseDouble(time_min.getText().toString());
        }
        if(str5.equals("")) {
                timeSec = 0;
            } else {
                timeSec = Double.parseDouble(time_sec.getText().toString());
        }

    }
}
