package com.example.android.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the home Activity
        startActivity(new Intent (SplashActivity.this, ActivityStart.class));

        // Close the splash Activity
        finish();

    }

}
