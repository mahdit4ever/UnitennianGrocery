package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Stack;

/**
 * Created by mahdi on 8/1/2016.
 */
public class Tesco extends AppCompatActivity {

    public static Stack<String> Tesco = new Stack();
    public static Stack <Double> TescoQ = new Stack();

    Button tescoPay;

    ListView listTesco;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tesco);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        tescoPay = (Button)findViewById(R.id.payTesco);
        ViewTesco();

        context=this;

        listTesco=(ListView)findViewById(R.id.listChartTesco);
        listTesco.setAdapter(new CustomChart(this,Tesco, TescoQ));
    }

    public void ViewTesco() {
        tescoPay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(Tesco.this, PaymentMethod.class));
                        else
                            return;
                    }
                }
        );
    }
}
