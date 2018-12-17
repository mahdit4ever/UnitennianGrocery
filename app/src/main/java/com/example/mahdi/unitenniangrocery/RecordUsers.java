package com.example.mahdi.unitenniangrocery;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahdi on 9/7/2016.
 */
public class RecordUsers extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_users);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Log.d("New DatabaseHelper", "SUCCESSFUL");
        // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.abs_layout);

        spinner.setOnItemSelectedListener(this);

        List<String> user = new ArrayList<String>();

        user.add("All");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, user);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        final DatabaseHelper db = new DatabaseHelper(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item


        TextView Stored;
        Stored = (TextView) findViewById(R.id.stored);
        DatabaseHelper db = new DatabaseHelper(this);
        String item = parent.getItemAtPosition(position).toString();

        if (item == "All") {
            Stored.setText("");
            Log.d("Reading: ", "Reading all records..");
            List<Record> records = db.getAllRecords();

            for (Record record : records) {
                String log = "Id: " + record.getId() + " ,NAME: " + record.getName() + " ,PHONE_NO: " + record.getPhone_no()
                        + " ADDRESS: " + record.getAddress() + "\n";
                // Writing records to log
                Log.d("Reading record: ", log);
                Stored.append(log);
            }
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
