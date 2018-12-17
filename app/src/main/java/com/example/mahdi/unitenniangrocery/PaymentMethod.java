package com.example.mahdi.unitenniangrocery;

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
 * Created by mahdi on 8/3/2016.
 */
public class PaymentMethod extends AppCompatActivity {
  private RadioButton cashh, credit,visa, master;
  private   RadioGroup group, cardType;
  private Button checkOut;
    EditText card_no, mm, yy,cvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        onRadioButtonClicked();

    }

    public void onRadioButtonClicked() {

        group = (RadioGroup)findViewById(R.id.cashcredit);
        checkOut = (Button)findViewById(R.id.check);


        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = group.getCheckedRadioButtonId();
                cashh=(RadioButton)findViewById(R.id.cash);
                credit=(RadioButton)findViewById(R.id.credit);


                if(cashh.isChecked()){
                    MainActivity.G_total=0.0;
                    MainActivity.M_total=0.0;
                    MainActivity.T_total=0.0;

                    startActivity(new Intent(PaymentMethod.this, CashOnDeliveryDate.class));
                }

                else if(credit.isChecked()){

                    MainActivity.G_total=0.0;
                    MainActivity.M_total=0.0;
                    MainActivity.T_total=0.0;

                    cardType = (RadioGroup)findViewById(R.id.visamaster);
                    int selected = group.getCheckedRadioButtonId();
                    visa=(RadioButton)findViewById(R.id.visa);
                    master=(RadioButton)findViewById(R.id.master);
                    card_no=(EditText)findViewById(R.id.card_no);
                    mm=(EditText)findViewById(R.id.datem);
                    yy=(EditText)findViewById(R.id.datey);
                    cvc=(EditText)findViewById(R.id.cvc);
                    if(visa.isChecked()) {
                        card_no.getText().toString();
                        yy.getText().toString();
                        cvc.getText().toString();
                        if (card_no.getText().toString().equals("")||yy.getText().toString().equals("")||cvc.getText().toString().equals("")){

                            Toast.makeText(PaymentMethod.this, "Please fill up all the data", Toast.LENGTH_LONG).show();
                        }
                        else
                            startActivity(new Intent(PaymentMethod.this, FinalCredit.class));
                    }
                    else if (master.isChecked()){
                        card_no.getText().toString();
                        yy.getText().toString();
                        cvc.getText().toString();
                        if (card_no.getText().toString().equals("")||yy.getText().toString().equals("")||cvc.getText().toString().equals("")){

                            Toast.makeText(PaymentMethod.this, "Please fill up all the data", Toast.LENGTH_LONG).show();
                        }
                        else
                            startActivity(new Intent(PaymentMethod.this, FinalCredit.class));
                    }

                    else
                        Toast.makeText(PaymentMethod.this, "Please select a type of your card", Toast.LENGTH_LONG).show();

                    }
                else
                    Toast.makeText(PaymentMethod.this, "Please select a payment method first", Toast.LENGTH_LONG).show();

                }

        });

   /* @Override
    public void onClick(View v) {
        my_button.setBackgroundResource(R.drawable.icon);

        // Execute some code after 2 seconds have passed
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                my_button.setBackgroundResource(R.drawable.defaultcard);
            }
        }, 2000);
    }*/
        }

}
