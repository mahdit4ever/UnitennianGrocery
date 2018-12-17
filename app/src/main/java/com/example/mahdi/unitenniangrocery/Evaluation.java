package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by mahdi on 9/1/2016.
 */
public class Evaluation extends AppCompatActivity {
    Context context;
    private RadioGroup groups;
    private RadioButton received, comment;
    private Button submit;
    EditText no, suggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluation);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);


        no = (EditText) findViewById(R.id.trackno);
        suggestions = (EditText) findViewById(R.id.comment);

        onClicks();

    }

    public void onClicks() {


        groups = (RadioGroup) findViewById(R.id.trackgroup);
        submit = (Button) findViewById(R.id.confirmtrack);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = groups.getCheckedRadioButtonId();

                received = (RadioButton) findViewById(R.id.accept);
                comment = (RadioButton) findViewById(R.id.comments);


                no.getText().toString();


                if (no.getText().toString().equals("")) {
                    Toast.makeText(Evaluation.this, "Please type your tracking no to submit", Toast.LENGTH_LONG).show();
                }
                else
                if (received.isChecked()){

                    startActivity(new Intent(Evaluation.this, ItemsType.class));

                }
                else if (comment.isChecked()){
                    suggestions.getText().toString();
                    if (suggestions.getText().toString().equals("")){
                        Toast.makeText(Evaluation.this, "Please write your comments to proceed", Toast.LENGTH_LONG).show();
                    }
                    else
                        startActivity(new Intent(Evaluation.this, Comment.class));
                }
                else
                    Toast.makeText(Evaluation.this, "Please choose either option", Toast.LENGTH_LONG).show();


            }


        });
    }
}
