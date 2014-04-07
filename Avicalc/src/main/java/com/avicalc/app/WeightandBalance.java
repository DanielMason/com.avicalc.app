package com.avicalc.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WeightandBalance extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_and_balance);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void setAircraft(View v) {
        final EditText bew_weight = (EditText)findViewById(R.id.bew_weight);
        final EditText pilot_weight = (EditText)findViewById(R.id.pilot_weight);
        final EditText copilot_weight = (EditText)findViewById(R.id.copilot_weight);
        final EditText pax_weight = (EditText)findViewById(R.id.pax_weight);
        final EditText fuel_weight = (EditText)findViewById(R.id.fuel_weight);

        final EditText bew_arm = (EditText)findViewById(R.id.bew_arm);
        final EditText pilot_arm = (EditText)findViewById(R.id.pilot_arm);
        final EditText copilot_arm = (EditText)findViewById(R.id.copilot_arm);
        final EditText pax_arm = (EditText)findViewById(R.id.pax_arm);
        final EditText fuel_arm = (EditText)findViewById(R.id.fuel_arm);

        final TextView bew_moment = (TextView)findViewById(R.id.bew_moment);
        final TextView pilot_moment = (TextView)findViewById(R.id.pilot_moment);
        final TextView copilot_moment = (TextView)findViewById(R.id.copilot_moment);
        final TextView pax_moment = (TextView)findViewById(R.id.pax_moment);
        final TextView fuel_moment = (TextView)findViewById(R.id.fuel_moment);

        final TextView totalWeight = (TextView)findViewById(R.id.total_weight);
        final TextView totalArm = (TextView)findViewById(R.id.total_arm);
        final TextView totalMoment = (TextView)findViewById(R.id.total_moment);

        switch (v.getId()) {
            case R.id.set172R:
                bew_weight.setText("0");
                pilot_weight.setText("85");
                copilot_weight.setText("0");
                pax_weight.setText("0");
                fuel_weight.setText("0");
                
                bew_arm.setText("0");
                pilot_arm.setText("37");
                copilot_arm.setText("37");
                pax_arm.setText("73");
                fuel_arm.setText("48");
                
                bew_moment.setText("");
                pilot_moment.setText("");
                copilot_moment.setText("");
                pax_moment.setText("");
                fuel_moment.setText("");

                totalWeight.setText("");
                totalArm.setText("");
                totalMoment.setText("");
                break;

            case R.id.setZero:
                bew_weight.setText("0");
                pilot_weight.setText("0");
                copilot_weight.setText("0");
                pax_weight.setText("0");
                fuel_weight.setText("0"); 
                
                bew_arm.setText("0");
                pilot_arm.setText("0");
                copilot_arm.setText("0");
                pax_arm.setText("0");
                fuel_arm.setText("0");

                bew_moment.setText("");
                pilot_moment.setText("");
                copilot_moment.setText("");
                pax_moment.setText("");
                fuel_moment.setText("");

                totalWeight.setText("");
                totalArm.setText("");
                totalMoment.setText("");
                break;
        }
    }
    public void calcWeight(View v) {
        EditText bew_weight = (EditText)findViewById(R.id.bew_weight);
        EditText pilot_weight = (EditText)findViewById(R.id.pilot_weight);
        EditText copilot_weight = (EditText)findViewById(R.id.copilot_weight);
        EditText pax_weight = (EditText)findViewById(R.id.pax_weight);
        EditText fuel_weight = (EditText)findViewById(R.id.fuel_weight);

        EditText bew_arm = (EditText)findViewById(R.id.bew_arm);
        EditText pilot_arm = (EditText)findViewById(R.id.pilot_arm);
        EditText copilot_arm = (EditText)findViewById(R.id.copilot_arm);
        EditText pax_arm = (EditText)findViewById(R.id.pax_arm);
        EditText fuel_arm = (EditText)findViewById(R.id.fuel_arm);

        TextView bew_moment = (TextView)findViewById(R.id.bew_moment);
        TextView pilot_moment = (TextView)findViewById(R.id.pilot_moment);
        TextView copilot_moment = (TextView)findViewById(R.id.copilot_moment);
        TextView pax_moment = (TextView)findViewById(R.id.pax_moment);
        TextView fuel_moment = (TextView)findViewById(R.id.fuel_moment);

        TextView totalWeight = (TextView)findViewById(R.id.total_weight);
        TextView totalArm = (TextView)findViewById(R.id.total_arm);
        TextView totalMoment = (TextView)findViewById(R.id.total_moment);
        TextView totalCofG = (TextView)findViewById(R.id.total_cofg);

        /*
        String check1 = bew_weight.getText().toString();
        String check2 = pilot_weight.getText().toString();
        String check3 = copilot_weight.getText().toString();
        String check4 = pax_weight.getText().toString();
        String check5 = fuel_weight.getText().toString();


        double finalInput = 0;
        double input1;

        if(str1.equals("")) {
            input1 = 1;
        } else {
            input1 = Double.parseDouble(textInput1.getText().toString());
        }
        */

        double bewWeight = Double.parseDouble(bew_weight.getText().toString());
        double bewArm = Double.parseDouble(bew_arm.getText().toString());
        double bewMoment = bewWeight * bewArm;
        bew_moment.setText(String.valueOf(bewMoment));

        double pilotWeight = Double.parseDouble(pilot_weight.getText().toString());
        double pilotArm = Double.parseDouble(pilot_arm.getText().toString());
        double pilotMoment = pilotWeight * pilotArm;
        pilot_moment.setText(String.valueOf(pilotMoment));

        double copilotWeight = Double.parseDouble(copilot_weight.getText().toString());
        double copilotArm = Double.parseDouble(copilot_arm.getText().toString());
        double copilotMoment = copilotWeight * copilotArm;
        copilot_moment.setText(String.valueOf(copilotMoment));

        double paxWeight = Double.parseDouble(pax_weight.getText().toString());
        double paxArm = Double.parseDouble(pax_arm.getText().toString());
        double paxMoment = paxWeight * paxArm;
        pax_moment.setText(String.valueOf(paxMoment));

        double fuelWeight = Double.parseDouble(fuel_weight.getText().toString());
        double fuelArm = Double.parseDouble(fuel_arm.getText().toString());
        double fuelMoment = fuelWeight * fuelArm;
        fuel_moment.setText(String.valueOf(fuelMoment));
       
        double weightTotal = bewWeight + pilotWeight + copilotWeight + paxWeight + fuelWeight;
        double armTotal = bewArm + pilotArm + copilotArm + paxArm + fuelArm;
        double momentTotal = bewMoment + pilotMoment + copilotMoment + paxMoment + fuelMoment;
        double cofgTotal = momentTotal / weightTotal;

        totalWeight.setText(String.valueOf(weightTotal));
        totalArm.setText(String.valueOf(armTotal));
        totalMoment.setText(String.valueOf(momentTotal));
        totalCofG.setText(String.valueOf(cofgTotal));


    }
}