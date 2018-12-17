package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by mahdi on 8/1/2016.
 */
public class Hypermarkets extends AppCompatActivity {

    NumberFormat nm = NumberFormat.getNumberInstance();

    TextView g_textView, m_textView, t_textView;
    String curruncy = "RM ";
    //Context context;
    Button Giant, Mydin, Tesco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hypermarket_selection);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        g_textView=(TextView)findViewById(R.id.t_giant);
        m_textView=(TextView)findViewById(R.id.t_mydin);
        t_textView=(TextView)findViewById(R.id.t_tesco);
        Giant=(Button)findViewById(R.id.giant);
        Mydin=(Button)findViewById(R.id.mydin);
        Tesco=(Button)findViewById(R.id.tesco);
        ViewHypermarket1();
        ViewHypermarket2();
        ViewHypermarket3();

        g_textView.setText(curruncy+nm.format(MainActivity.G_total));
        m_textView.setText(curruncy+nm.format(MainActivity.M_total));
        t_textView.setText(curruncy+nm.format(MainActivity.T_total));
    }


    public void ViewHypermarket1() {
        Giant.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(Hypermarkets.this, Giant.class));
                        else
                            return;
                    }
                }
        );
    }

    public void ViewHypermarket2() {
        Mydin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(Hypermarkets.this, Mydin.class));
                        else
                            return;
                    }
                }
        );
    }
    public void ViewHypermarket3() {
        Tesco.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean clicked;
                        if (clicked = true)
                            startActivity(new Intent(Hypermarkets.this, Tesco.class));
                        else
                            return;
                    }
                }
        );
    }
}

