package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by mahdi on 7/28/2016.
 */
public class FreshFruits extends AppCompatActivity {

    ListView lv;
    Context context;
    ArrayList prgmName;
    Button PF;

    public static String[] Fruits = {"Apples", "Bananas", "Oranges", "Kiwis", "Peaches", "Melon", "Strawberry", "Nectarines", "Grapes", "Plums" };
    public static String[] Amount = {"KG", "KG", "KG", "KG", "KG", "KG", "KG", "KG", "KG", "KG"};
    public static Double[] G_fruit_price ={7.99, 5.00, 6.99, 11.99, 8.7, 4.7, 12.6, 6.7, 13.5, 9.99};
    public static Double[] M_fruit_price ={6.99, 4.5, 6.99, 11.65, 8.75, 4.5, 12.00, 6.75, 13.2, 9.8};
    public static Double[] T_fruit_price ={7.99, 4.35, 6.9, 13.99, 8.8, 4.75, 13.00, 6.65, 13.5, 9.85};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        PF=(Button)findViewById(R.id.BF);
        ViewOrder();

       context=this;

        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, Fruits, Amount, G_fruit_price, M_fruit_price,T_fruit_price));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void ViewOrder() {
        PF.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (Giant.Giant.isEmpty()|| Mydin.Mydin.isEmpty()|| Tesco.Tesco.isEmpty()){

                            Toast.makeText(context,"Please add item(s) to your chart to proceed",Toast.LENGTH_LONG).show();
                        } else {
                            MainActivity.increment = MainActivity.increment + 1;
                            if (clicked = true)
                                startActivity(new Intent(FreshFruits.this, Hypermarkets.class));
                            else
                                return;
                        }
                    }
                }
        );
    }

}

