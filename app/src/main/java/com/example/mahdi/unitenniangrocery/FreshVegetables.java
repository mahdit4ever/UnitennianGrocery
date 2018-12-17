package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mahdi on 7/21/2016.
 */
public class FreshVegetables extends AppCompatActivity {

    ListView lv;
    Context context;
    ArrayList prgmName;
    Button PV;


    public static String[] Vegetables = {"Onions", "Potato", "Peppers", "Carrots", "Broccoli", "Corn", "Tomatoes", "Zucchini", "Mushrooms", "Celery"};
    public static String[] Amount = {"KG", "KG", "PES", "KG", "PNL", "PES", "KG", "KG", "KG", "PNL"};
    public static Double[] G_vegetable_price ={3.4, 3.99, 1.7, 4.5, 5.35, 1.8, 3.99, 4.7, 5.7, 4.4};
    public static Double[] M_vegetable_price ={3.35, 3.9, 1.6, 5.15, 5.35, 1.85, 3.45, 4.8, 5.55, 4.3};
    public static Double[] T_vegetable_price ={3.45, 4.15, 1.9, 4.7, 5.4, 1.85, 4.05, 4.75, 5.8, 4.45};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetable);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        PV=(Button)findViewById(R.id.BV);
        ViewOrder();

        context=this;

        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, Vegetables, Amount, G_vegetable_price,M_vegetable_price,T_vegetable_price));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void ViewOrder() {
        PV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (Giant.Giant.isEmpty()|| Mydin.Mydin.isEmpty()|| Tesco.Tesco.isEmpty()){

                            Toast.makeText(context,"Please add item(s) to your chart to proceed",Toast.LENGTH_LONG).show();
                        } else {
                            MainActivity.increment = MainActivity.increment + 1;
                            if (clicked = true)
                                startActivity(new Intent(FreshVegetables.this, Hypermarkets.class));
                            else
                                return;
                        }
                    }
                }
        );
    }

}

