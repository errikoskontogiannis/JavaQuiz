package com.example.android.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FifthQuestion extends AppCompatActivity {
    // Initializing Variables
    int score = Utility.score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_fifth);

        // Receiving data from previous Activity with a bundle
        Intent i = getIntent();
        final Bundle bundle = i.getExtras();
        final String name = bundle.getString("name");
        final String email = bundle.getString("email");
        score = bundle.getInt("score");

        // Initializing nextButton object
        Button btnNextScreen = (Button) findViewById(R.id.nextButton5);

        // Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), SixthQuestion.class);

                // Checking if correct answers are checked and if yes adding one to the score
                CheckBox question5CB1 = (CheckBox) findViewById(R.id.question5Answer1);
                CheckBox question5CB2 = (CheckBox) findViewById(R.id.question5Answer2);
                CheckBox question5CB3 = (CheckBox) findViewById(R.id.question5Answer3);
                CheckBox question5CB4 = (CheckBox) findViewById(R.id.question5Answer4);

                if (question5CB1.isChecked()) {

                    if (question5CB4.isChecked()) {

                        if (question5CB2.isChecked()) {



                        } else if (question5CB3.isChecked()) {



                        } else {

                            score += 1;

                        }

                    }

                }

                //Sending data to next Activity with a bundle
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
