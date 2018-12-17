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
 * Created by mahdi on 7/28/2016.
 */
public class BackedGoods extends AppCompatActivity {

    ListView lv;
    Context context;
    ArrayList prgmName;
    Button PB;

    public static String[] Baked_goods = {"Fresh_bread", "Sliced_bread", "Cake", "Cookies", "Pastries", "Donuts", "Pita_bread", "Bagels", "Croissants", "Pound_cake"};
    public static String[] Amount = {"PES", "PKG", "ROLL", "PKG", "PES", "PES", "PKG", "PES", "PES", "PES"};
    public static Double[] G_backed_price ={2.00, 3.4, 13.00, 16.00, 3.5, 2.5, 3.7, 3.00, 2.8, 1.7};
    public static Double[] M_backed_price ={1.9, 3.35, 12.00, 16.15, 3.2, 2.4, 3.5, 2.8, 2.75, 1.65};
    public static Double[] T_backed_price ={2.2, 3.4, 13.1, 18.00, 3.5, 2.6, 3.99, 3.30, 2.9, 1.6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backed_goods);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        PB=(Button)findViewById(R.id.BB);
        ViewOrder();

        context=this;

        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, Baked_goods, Amount, G_backed_price, M_backed_price, T_backed_price));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void ViewOrder() {
        PB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (Giant.Giant.isEmpty() || Mydin.Mydin.isEmpty() || Tesco.Tesco.isEmpty()) {

                            Toast.makeText(context, "Please add item(s) to your chart to proceed", Toast.LENGTH_LONG).show();
                        } else {
                            MainActivity.increment = MainActivity.increment + 1;
                            if (clicked = true)
                                startActivity(new Intent(BackedGoods.this, Hypermarkets.class));
                            else
                                return;
                        }
                    }
                }
        );
    }

}

