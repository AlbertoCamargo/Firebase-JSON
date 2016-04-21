package com.augustosalazar.androidjson;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditActivity extends ActionBarActivity {

    // Array Adapter for genders
    private ArrayAdapter<CharSequence> adapter;
    private Spinner gender;
    private EditText name,lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        name = (EditText) findViewById(R.id.editName);
        lastName = (EditText) findViewById(R.id.lastName);
        gender = (Spinner) findViewById(R.id.editGender);


        configureSpinner();

    }


    private void configureSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.genders, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        gender.setAdapter(adapter);
    }

    public void edit(View view) {

        Button edit = (Button) findViewById(R.id.delete);
        Log.d("TAGGGGG", edit.toString());


    }
}
