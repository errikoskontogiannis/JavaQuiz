package com.example.android.javaquiz;

import android.app.Application;
import android.os.SystemClock;

public class SplashActivityClock extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Splash Activity timer
        SystemClock.sleep(750);

    }

}
