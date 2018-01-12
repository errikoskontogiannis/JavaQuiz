package com.example.android.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdQuestion extends AppCompatActivity {
    // Initializing Variables
    int score = 0;
    String answer = "boolean name = true;";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_third);

        // Receiving data from previous Activity with a bundle
        Intent i = getIntent();
        final Bundle bundle = i.getExtras();
        final String name = bundle.getString("name");
        final String email = bundle.getString("email");
        score = bundle.getInt("score");

        // Initializing nextButton object
        Button btnNextScreen = (Button) findViewById(R.id.nextButton3);

        // Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), FourthQuestion.class);

                // Checking if correct answer is written and if yes adding one point to the score
                EditText question3ET = (EditText) findViewById(R.id.question3Answer1);

                if (question3ET.getText().toString().equalsIgnoreCase(answer)) {

                    score += 1;

                }

                // Sending data to next Activity with a bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("email", email);
                bundle.putInt("score", score);

                nextScreen.putExtras(bundle);

                // Continuing to next Activity
                startActivity(nextScreen);

            }
        });

    }

}