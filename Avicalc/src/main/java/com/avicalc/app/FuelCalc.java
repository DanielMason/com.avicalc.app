package com.avicalc.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FuelCalc extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel_calc);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        spinnerFrom.setSelection(1);
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
    public void convertNow(View v) {


        TextView textOutput1 = (TextView) findViewById(R.id.textOutput1);
        EditText textInput1 = (EditText)findViewById(R.id.textInput1);
        Button buttonConvert = (Button) findViewById(R.id.buttonConvert);
        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerTo);

        Object spinner1 = spinnerFrom.getSelectedItem();
        Object spinner2 = spinnerTo.getSelectedItem();

        String str1 = textInput1.getText().toString();
        double finalInput = 0;
        double input1;

        if(str1.equals("")) {
            input1 = 1;
        } else {
            input1 = Double.parseDouble(textInput1.getText().toString());
        }

        if (spinner1.equals(spinner2)) {
            finalInput = input1;
        }
        else if (spinner1.equals("Litres")) {
            if (spinner2.equals("US Gal.")) {
                finalInput = input1 * 0.26417205235814845;
            } else if (spinner2.equals("Imperial Gal.")) {
                finalInput = input1 * 0.2199736031676198;
            }
        }
        else if (spinner1.equals("US Gal.")) {
            if (spinner2.equals("Litres")) {
                finalInput = input1 * 3.785411784;
            } else if (spinner2.equals("Imperial Gal.")) {
                finalInput = input1 * 0.8327;
            }
        }
        else if (spinner1.equals("Imperial Gal.")) {
            if (spinner2.equals("US Gal.")) {
                finalInput = input1 * 1.201;
            } else if (spinner2.equals("Litres")) {
                finalInput = input1 * 4.546;
            }
        }
        finalInput = Math.round(finalInput * 100);
        finalInput = finalInput/100;
        textOutput1.setText(String.valueOf(finalInput));
    }
}