package com.example.mahdi.unitenniangrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahdi on 8/27/2016.
 */
public class FinalCredit extends AppCompatActivity {
    TextView increm;

    NumberFormat nm = NumberFormat.getNumberInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_credit);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        Timer timer = new Timer();
        timer.schedule(task, delay);

        increm=(TextView)findViewById(R.id.incrementt);

        increm.setText(nm.format(MainActivity.increment));
    }
    private long delay = 10000;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            startActivity(new Intent(FinalCredit.this, ItemsType.class));

            Giant.Giant.clear();
            Mydin.Mydin.clear();
            Tesco.Tesco.clear();
            Giant.GiantQ.clear();
            Mydin.MydinQ.clear();
            Tesco.TescoQ.clear();

            finish();
        }

    };
}
