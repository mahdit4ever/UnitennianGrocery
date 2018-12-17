package com.example.mahdi.unitenniangrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mahdi on 7/17/2016.
 */
public class ItemsType extends AppCompatActivity {
    TextView vegetables, fruits, backedGoods, otherStuff, track;
    EditText editName, editPhone, editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_type);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        vegetables = (TextView)findViewById(R.id.VS);
        fruits = (TextView)findViewById(R.id.FS);
        backedGoods = (TextView)findViewById(R.id.BG);
        otherStuff = (TextView)findViewById(R.id.OS);
        track = (TextView)findViewById(R.id.track);
        editName = (EditText) findViewById(R.id.TFname);
        editPhone = (EditText) findViewById(R.id.TFphone);
        editAddress = (EditText) findViewById(R.id.TFaddress);
        ViewVegetable();
        ViewFruit();
        ViewGoods();
        ViewOther();
        tracking();
    }

    public void ViewVegetable() {
        vegetables.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(ItemsType.this, FreshVegetables.class));
                        else
                            return;
                    }
                }
        );

    }

    public void ViewFruit() {
        fruits.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(ItemsType.this, FreshFruits.class));
                        else
                            return;
                    }
                }
        );

    }

    public void ViewGoods() {
        backedGoods.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(ItemsType.this, BackedGoods.class));
                        else
                            return;
                    }
                }
        );
    }
    public void ViewOther() {
        otherStuff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(ItemsType.this, OtherStuff.class));
                        else
                            return;
                    }
                }
        );

    }

    public void tracking() {
        track.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(ItemsType.this, Evaluation.class));
                        else
                            return;
                    }
                }
        );

    }

}

