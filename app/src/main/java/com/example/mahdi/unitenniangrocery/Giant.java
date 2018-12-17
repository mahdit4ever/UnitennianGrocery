package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mahdi on 8/1/2016.
 */
public class Giant extends AppCompatActivity {

    public static Stack <String> Giant = new Stack();
    public static Stack <Double> GiantQ = new Stack();

    Button giantPay;

    ListView listGiant;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giant);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        giantPay = (Button)findViewById(R.id.payGient);
        ViewGient();


        context=this;

        listGiant=(ListView)findViewById(R.id.listChartGiant);
        listGiant.setAdapter(new CustomChart(this,Giant, GiantQ));

    }



    public void ViewGient() {
        giantPay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(Giant.this, PaymentMethod.class));
                        else
                            return;
                    }
                }
        );
    }
}
