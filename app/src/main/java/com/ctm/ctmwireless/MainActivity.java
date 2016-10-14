package com.ctm.ctmwireless;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.defaultHeight;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    int discountSum = 0;
    double discount = 0.1;
    double price30 = 30.0;
    double price40 = 40.0;
    double price50 = 50.0;
    double price60 = 60.0;
    double planSelected = 0.0;
    double yourCost;
    int offer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final RadioButton planOneGB = (RadioButton) findViewById(R.id.btnData1);
        final RadioButton planThreeGB = (RadioButton) findViewById(R.id.btnData3);
        final RadioButton planFiveGB = (RadioButton) findViewById(R.id.btnData5);
        final RadioButton planTenGB = (RadioButton) findViewById(R.id.btnData10);
        final RadioButton noFee = (RadioButton) findViewById(R.id.noActFee);
        final RadioButton switchNow = (RadioButton) findViewById(R.id.switchProvider);
        final RadioButton newPhone = (RadioButton) findViewById(R.id.freePhone);
        final TextView result = (TextView)findViewById(R.id.txtCost);
        Button getStarted = (Button)findViewById(R.id.btnGetStarted);
        // Check for selected plan
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnData1:
                        planOneGB.isChecked();
                        planSelected = price30;
                        break;
                    case  R.id.btnData3:
                        planThreeGB.isChecked();
                        planSelected = price40;
                        break;
                    case R.id.btnData5:
                        planFiveGB.isChecked();
                        planSelected = price50;
                        break;
                    case R.id.btnData10:
                        planTenGB.isChecked();
                        planSelected = price60;
                        break;
                    case R.id.noActFee:
                        noFee.isChecked();
                        offer = offer + 1;
                        break;
                    case R.id.freePhone:
                        newPhone.isChecked();
                        offer = offer + 1;
                        break;
                    case  R.id.switchProvider:
                        switchNow.isChecked();
                        offer = offer + 1;
                        break;
                    default:
                        planSelected = 0.0;
                }
            }
        });
        if(offer >= 2) {
            yourCost = planSelected * 0.9;
        } else {
            yourCost = planSelected;
        }
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        result.setText("Your monthly plan will cost " + currency.format(yourCost));
    }
}

