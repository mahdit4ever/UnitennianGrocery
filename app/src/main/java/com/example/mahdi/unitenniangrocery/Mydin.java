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
public class Mydin extends AppCompatActivity {

    public static Stack<String> Mydin = new Stack();
    public static Stack <Double> MydinQ = new Stack();

    Button mydinPay;

    ListView listMydin;
    Context context;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydin);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        mydinPay = (Button)findViewById(R.id.payMydin);
        ViewMydin();

        context=this;

        listMydin=(ListView)findViewById(R.id.listChartMydin);
        listMydin.setAdapter(new CustomChart(this,Mydin, MydinQ));
    }

    public void ViewMydin() {
        mydinPay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(Mydin.this, PaymentMethod.class));
                        else
                            return;
                    }
                }
        );
    }
}
