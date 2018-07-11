package com.example.a17010621.p08myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.RadioGroupGender);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Step 1a: Get the user input from EditText and store it in a variable
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        Float gpa = Float.parseFloat(strGPA);
        int gender = rgGender.getCheckedRadioButtonId();

        // Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1d: Add the key-value pair (Value should be from the variable defined in Step 1a
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("gender", gender);

        // Step 1e: Call commit() method to save changes into the SharedPreferences
        prefEdit.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        // Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Step 2b: Retrieve the saved data from the SharedPreferences object
        String msgName = prefs.getString("name","");
        Float msgGPA = prefs.getFloat("gpa",0);
        int msgGender = prefs.getInt("gender", 0);

        // Step 2c: Update the UI element with the value
        etName.setText(msgName);
        etGPA.setText(msgGPA + "");
        rgGender.check(msgGender);


    }
}

