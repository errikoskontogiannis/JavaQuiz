package com.example.android.javaquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEnd extends AppCompatActivity {
    // Initializing Variables
    int score = 0;
    String results_email_subject = "";
    String message = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_activity);

        // Receiving data from previous Activity with a bundle
        Intent i = getIntent();
        final Bundle bundle = i.getExtras();
        final String name = bundle.getString("name");
        final String email = bundle.getString("email");
        score = bundle.getInt("score");

        // Editing the two Strings now that we have the data from the previous Activity
        results_email_subject = ("JavaQuiz Results For " + name);
        message = ("Name: " + name + "\nEmail: " + email + "\nYour Score:" + "\n" + score + "/8");

        // Changing TextView text to the name
        TextView nameEndTextView = (TextView) findViewById(R.id.nameTextView);
        nameEndTextView.setText(getString(R.string.name) + name);

        // Changing TextView text to the email
        TextView emailEndTextView = (TextView) findViewById(R.id.emailTextView);
        emailEndTextView.setText(getString(R.string.email) + email);

        // Changing TextView text to the score
        TextView scoreEndTextView = (TextView) findViewById(R.id.scoreTextView);
        scoreEndTextView.setText(score + getString(R.string.slash_8));

        // Initializing btnNextScreen and btnEmailResults objects
        Button btnNextScreen = (Button) findViewById(R.id.startAgainButton);
        Button btnEmailResults = (Button) findViewById(R.id.emailResultsButton);

        // Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), ActivityStart.class);

                // Continuing to ActivityStart to start the quiz again
                startActivity(nextScreen);

            }

        });

        // Listening to button event
        btnEmailResults.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                // Using an intent to launch an email app.
                // Sending the results message in the email body.
                Intent emailResults = new Intent(Intent.ACTION_SENDTO);
                emailResults.setData(Uri.parse("mailto:")); // only email apps should handle this
                emailResults.putExtra(Intent.EXTRA_SUBJECT, results_email_subject);
                emailResults.putExtra(Intent.EXTRA_TEXT, message);

                if (emailResults.resolveActivity(getPackageManager()) != null) {

                    startActivity(emailResults);

                }

            }

        });

    }

}