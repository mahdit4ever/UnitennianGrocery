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
 * Created by mahdi on 7/29/2016.
 */
public class OtherStuff extends AppCompatActivity {

    ListView lv;
    Context context;
    ArrayList prgmName;
    Button PO;

    public static String[] Other_stuff = {"Tuna", "Oatmeal", "Cola", "Potato_chips", "Sugar", "Popcorn", "Yogurt", "Butter", "Cheddar", "Salt"};
    public static String[] Amount = {"PES", "PKG", "PES", "PKG", "PKG", "PKG", "PES", "PKG", "PKG", "PKG"};
    public static Double[] G_other_price ={5.6, 7.99, 1.55, 4.00, 2.9, 3.3, 4.5, 9.7, 8.99, 2.05};
    public static Double[] M_other_price ={5.5, 7.7, 1.50, 4.15, 2.7, 3.25, 4.4, 9.6, 8.9, 2.1};
    public static Double[] T_other_price ={5.7, 7.99, 1.6, 3.99, 2.85, 3.4, 4.2, 9.99, 8.9, 2.00};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_stuff);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        PO=(Button)findViewById(R.id.BO);
        ViewOrder();

        context=this;

        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, Other_stuff, Amount, G_other_price, M_other_price, T_other_price));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void ViewOrder() {
        PO.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (Giant.Giant.isEmpty()|| Mydin.Mydin.isEmpty()|| Tesco.Tesco.isEmpty()){

                            Toast.makeText(context,"Please add item(s) to your chart to proceed",Toast.LENGTH_LONG).show();
                        } else {
                            MainActivity.increment = MainActivity.increment + 1;
                            if (clicked = true)
                                startActivity(new Intent(OtherStuff.this, Hypermarkets.class));
                            else
                                return;
                        }
                    }
                }
        );
    }

}

