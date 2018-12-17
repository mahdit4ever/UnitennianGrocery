package com.example.mahdi.unitenniangrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahdi on 9/2/2016.
 */
public class Comment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commonts);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        Timer timer = new Timer();
        timer.schedule(task, delay);
    }
    private long delay = 10000;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            startActivity(new Intent(Comment.this, ItemsType.class));
        }

    };
}
