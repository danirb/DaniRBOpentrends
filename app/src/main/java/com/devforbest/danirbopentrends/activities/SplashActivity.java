package com.devforbest.danirbopentrends.activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devforbest.danirbopentrends.Constants;
import com.devforbest.danirbopentrends.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_avtivity);
        initCountDown();


    }



    private void initCountDown() {
        new CountDownTimer(Constants.TIME_SPLASH, Constants.TIME_SPLASH) {
            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                openNextView();
            }
        }.start();
    }

    private void openNextView() {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter, R.anim.exit);
            finish();

    }

}
