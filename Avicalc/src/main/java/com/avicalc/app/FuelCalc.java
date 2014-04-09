package com.avicalc.app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.avicalc.app.R.layout.*;

public class FuelCalc extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fuel_calc);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        EditText textInput = (EditText) findViewById(R.id.textInput1);
        EditText sgText = (EditText) findViewById(R.id.editText4);
        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerTo);

        spinnerFrom.getBackground().setColorFilter(Color.parseColor("#202020"), PorterDuff.Mode.MULTIPLY);
        spinnerTo.getBackground().setColorFilter(Color.parseColor("#202020"), PorterDuff.Mode.MULTIPLY);
        spinnerFrom.getPopupBackground().setColorFilter(Color.parseColor("#3C3C3C"), PorterDuff.Mode.MULTIPLY);
        spinnerTo.getPopupBackground().setColorFilter(Color.parseColor("#3C3C3C"), PorterDuff.Mode.MULTIPLY);

        spinnerFrom.setSelection(1);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateTotals();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateTotals();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                updateTotals();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        sgText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                updateTotals();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });
    }
    public void updateTotals() {
        TextView textOutput1 = (TextView) findViewById(R.id.textOutput1);
        EditText textInput1 = (EditText)findViewById(R.id.textInput1);
        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        EditText sgText = (EditText) findViewById(R.id.editText4);
        TextView weightText = (TextView) findViewById(R.id.textView4);

        Object spinner1 = spinnerFrom.getSelectedItem();
        Object spinner2 = spinnerTo.getSelectedItem();

        String str1 = textInput1.getText().toString();
        String str2 = sgText.getText().toString();
        double finalInput = 0;
        double input1;
        double sgTotal;
        double sgText1;
        double sgTotal2;
        double sgTotal3;

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


        if(str2.equals("")) {
            sgText1 = 0.72;
        } else {
            sgText1 = Double.parseDouble(sgText.getText().toString());
        }

        if (spinner1.equals("Litres")) {

                sgTotal = input1 * sgText1;
                sgTotal2 = Math.round(sgTotal * 100);
                sgTotal3 = sgTotal2/100;
                weightText.setText(String.valueOf(sgTotal3));

        } else if (spinner1.equals("US Gal.")) {

                input1 = input1 * 3.785411784;
                sgTotal = input1 * sgText1;
                sgTotal2 = Math.round(sgTotal * 100);
                sgTotal3 = sgTotal2/100;
                weightText.setText(String.valueOf(sgTotal3));

        } else if (spinner1.equals("Imperial Gal.")){

                input1 = input1 * 4.546;
                sgTotal = input1 * sgText1;
                sgTotal2 = Math.round(sgTotal * 100);
                sgTotal3 = sgTotal2/100;
                weightText.setText(String.valueOf(sgTotal3));

            }
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
}