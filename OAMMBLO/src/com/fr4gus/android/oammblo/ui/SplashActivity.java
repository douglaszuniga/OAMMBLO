package com.fr4gus.android.oammblo.ui;

import android.content.Intent;
import com.fr4gus.android.oammblo.R;

import android.os.Bundle;

/**
 * Shows App logo for few seconds.
 * 
 * @author Franklin Garcia
 * Created Mar 25, 2012
 */
public class SplashActivity extends OammbloActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
              //do nothing
        }
        Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

}
