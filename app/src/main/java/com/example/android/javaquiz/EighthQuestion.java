package com.example.android.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class EighthQuestion extends AppCompatActivity {
    // Initializing Variables
    int score = Utility.score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eighth);

        // Receiving data from previous Activity with a bundle
        Intent i = getIntent();
        final Bundle bundle = i.getExtras();
        final String name = bundle.getString("name");
        final String email = bundle.getString("email");
        score = bundle.getInt("score");

        // Initializing nextButton object
        Button btnNextScreen = (Button) findViewById(R.id.submitButton);

        // Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), ActivityEnd.class);

                // Checking if correct answers are checked and if yes adding one point to the score
                CheckBox question8CB1 = (CheckBox) findViewById(R.id.question8Answer1);
                CheckBox question8CB2 = (CheckBox) findViewById(R.id.question8Answer2);
                CheckBox question8CB3 = (CheckBox) findViewById(R.id.question8Answer3);
                CheckBox question8CB4 = (CheckBox) findViewById(R.id.question8Answer4);

                if (question8CB1.isChecked()) {

                    if (question8CB2.isChecked()) {

                        if (question8CB3.isChecked()) {



                        } else if (question8CB4.isChecked()) {



                        } else {

                            score += 1;

                        }

                    }

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
