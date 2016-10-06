package edu.orangecoastcollege.cs273.vnguyen629.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Define the TimerTask to launch MediaActivity
        TimerTask mediaTask = new TimerTask() {
            @Override
            public void run() {
                // Reason we finish is because we're not going back to the SplashScreen. Removes
                // all memory associated with it, (unloading the memory).
                finish();
                startActivity(new Intent (SplashScreenActivity.this, MediaActivity.class));
            }
        };

        Timer timer = new Timer();
        timer.schedule(mediaTask, 5000);
    }
}
