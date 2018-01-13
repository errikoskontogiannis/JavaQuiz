package com.example.android.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityStart extends AppCompatActivity {
    // Initializing variables
    EditText nameEditText;
    EditText emailEditText;
    String noNameOrEmail = "";
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        // Initializing objects
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        Button btnNextScreen = (Button) findViewById(R.id.startQuizButton);

        // Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), FirstQuestion.class);

                // Sending data to next Activity with a bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", nameEditText.getText().toString());
                bundle.putString("email", emailEditText.getText().toString());
                bundle.putInt("score", score);
                nextScreen.putExtras(bundle);

                // Initializing agreeCheckBox object
                CheckBox agreeCB = (CheckBox) findViewById(R.id.agreeCheckBox);

                // Check if name, email, checkbox is entered/checked or not and if yes do the methods below
                if (agreeCB.isChecked()) {

                    if (nameEditText.getText().toString().equalsIgnoreCase(noNameOrEmail)) {

                        Toast toast = Toast.makeText(getApplicationContext(), Utility.please_enter_a_name, Toast.LENGTH_SHORT);
                        toast.show();

                    } else if (emailEditText.getText().toString().equalsIgnoreCase(noNameOrEmail))  {

                        Toast toast = Toast.makeText(getApplicationContext(), Utility.please_enter_an_email, Toast.LENGTH_SHORT);
                        toast.show();


                    } else {

                        startActivity(nextScreen);

                    }

                } else {

                    Toast toast = Toast.makeText(getApplicationContext(), Utility.please_agree_to, Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });

    }
}
