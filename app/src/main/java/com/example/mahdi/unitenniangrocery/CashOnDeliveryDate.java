package com.example.mahdi.unitenniangrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by mahdi on 8/14/2016.
 */
public class CashOnDeliveryDate extends AppCompatActivity {
    Button setDate;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_on_delivery_date);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        setDate = (Button)findViewById(R.id.d_selection);
        SetDate();
    }

    public void SetDate() {
        setDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(CashOnDeliveryDate.this,CashOnDeliveryTime.class));
                        else
                            return;
                    }
                }
        );
    }

}
