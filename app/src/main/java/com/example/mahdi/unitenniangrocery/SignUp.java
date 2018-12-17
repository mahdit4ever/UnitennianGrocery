package com.example.mahdi.unitenniangrocery;

/*
 * Created by mahdi on 7/15/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
    EditText editName, editPhone, editAddress;
    Button signUp;
    String name, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_form);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        final DatabaseHelper db = new DatabaseHelper(this);
        Log.d("New DatabaseHelper","SUCCESSFUL");

        editName = (EditText) findViewById(R.id.TFname);
        editPhone = (EditText) findViewById(R.id.TFphone);
        editAddress = (EditText) findViewById(R.id.TFaddress);
        signUp = (Button) findViewById(R.id.button);

        signUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = editName.getText().toString();
                        phone = editPhone.getText().toString();
                        address = editAddress.getText().toString();

                        try {
                            db.addUser(new Record(1, name, phone, address));
                            Log.d("Insert Data: ", "SUCCESSFUL");

                        } catch (Exception e){

                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        if (editName.getText().toString().equals("") || editPhone.getText().toString().equals("") || editAddress.getText().toString().equals("")) {
                            Toast.makeText(SignUp.this, "Please fill up all your data", Toast.LENGTH_LONG).show();
                        } else {

                                startActivity(new Intent(SignUp.this, ItemsType.class));
                                Toast.makeText(SignUp.this, "You have signed up successfully", Toast.LENGTH_LONG).show();
                                editName.setText("");
                                editAddress.setText("");
                                editPhone.setText("");

                        }

                    }

                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_home:
                startActivity(new Intent(SignUp.this, SignUp.class));
                finish();
                break;
            case R.id.menu_about:
                startActivity(new Intent(SignUp.this, About.class));
                finish();
                break;
          //  case R.id.menu_record:
            //    startActivity(new Intent(SignUp.this, RecordUsers.class));
             //   finish();
             //   break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}


