package com.augustosalazar.androidjson;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class EditActivity extends ActionBarActivity {

    // Array Adapter for genders
    private ArrayAdapter<CharSequence> adapter;
    private Spinner gender;
    private EditText name,lastName;

    private DataEntry mDataEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        mDataEntry = (DataEntry) i.getSerializableExtra("data");

        name = (EditText) findViewById(R.id.editName);
        lastName = (EditText) findViewById(R.id.lastName);
        gender = (Spinner) findViewById(R.id.editGender);

        configureSpinner();

        name.setText(mDataEntry.getFistName());
        lastName.setText(mDataEntry.getLastName());
        gender.setSelection(adapter.getPosition(mDataEntry.getGender()), true);
        name.setText(mDataEntry.getFistName());



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
        String nameAttr = name.getText().toString();
        String lastNameAttr = lastName.getText().toString();
        String genderAttr = gender.getSelectedItem().toString();

        mDataEntry.setFistName(nameAttr);
        mDataEntry.setLastName(lastNameAttr);
        mDataEntry.setGender(genderAttr);

        Map<String, Object> item = new HashMap<>();

        item.put("user", mDataEntry);
        MainActivity.myFirebaseRef.child(mDataEntry.getFirebase()).setValue(item);





    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(EditActivity.this, DetailActivity.class);
        i.putExtra("data", mDataEntry);
        startActivity(i);
        //super.onBackPressed();
    }
}
