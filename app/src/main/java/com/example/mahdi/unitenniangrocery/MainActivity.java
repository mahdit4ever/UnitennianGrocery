package com.example.mahdi.unitenniangrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.TimerTask;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {
    ImageButton splash;

    public static int increment=1;

    //public static Stack <String> Item = new Stack();

    public static Double G_total=0.0;
    public static Double M_total=0.0;
    public static Double T_total=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timer timer = new Timer();
        timer.schedule(task, delay);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        splash = (ImageButton)findViewById(R.id.IB);
       Click();
    }

    private long delay = 1000;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            startActivity(new Intent(MainActivity.this, ItemsType.class));
            //finish();
        }
    };

    public void Click() {

        splash.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean clickButton;

                        if (clickButton = true)
                            startActivity(new Intent(MainActivity.this, SignUp.class));

                        else
                            Toast.makeText(MainActivity.this, "please make sure that you have launched the app correctly!", Toast.LENGTH_LONG);
                    }
                }
        );
    }

}

