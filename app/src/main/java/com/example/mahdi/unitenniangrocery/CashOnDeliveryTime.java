package com.example.mahdi.unitenniangrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by mahdi on 8/14/2016.
 */
public class CashOnDeliveryTime extends AppCompatActivity {
    Button setTime;
    private RadioGroup group;
    private RadioButton morning, afternoon, evening;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_on_delivery_time);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        //setTime = (Button)findViewById(R.id.t_selection);
        SetTime();
    }

    public void SetTime() {
        group=(RadioGroup) findViewById(R.id.group);
        setTime = (Button)findViewById(R.id.t_selection);

        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = group.getCheckedRadioButtonId();
                morning=(RadioButton)findViewById(R.id.morning);
                afternoon=(RadioButton)findViewById(R.id.afternoon);
                evening=(RadioButton)findViewById(R.id.evening);

                if(morning.isChecked()){
                    startActivity(new Intent(CashOnDeliveryTime.this, Final.class));
                }
                else if (afternoon.isChecked()){
                    startActivity(new Intent(CashOnDeliveryTime.this, Final.class));
                }
                else if(evening.isChecked()){
                    startActivity(new Intent(CashOnDeliveryTime.this, Final.class));
                }

                else
                    Toast.makeText(CashOnDeliveryTime.this, "Please select time for your delivery", Toast.LENGTH_LONG).show();
            }
        });

    }

}
