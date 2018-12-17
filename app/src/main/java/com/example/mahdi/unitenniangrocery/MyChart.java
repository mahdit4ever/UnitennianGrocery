package com.example.mahdi.unitenniangrocery;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by mahdi on 8/13/2016.
 */
public class MyChart extends AppCompatActivity {

    EditText quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mychart);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        quantity = (EditText)findViewById(R.id.quantity);



    }




}