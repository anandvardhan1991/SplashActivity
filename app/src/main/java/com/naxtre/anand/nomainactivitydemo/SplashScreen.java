package com.naxtre.anand.nomainactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Anand Vardhan on 9/28/2016.
 */
public class SplashScreen extends Activity {
    // Splash screen timer
    String getSharedPreferenceData=null;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                getSharedPreferenceData=Preferences.readString(SplashScreen.this,"RadioButtonSelected",null);
                if(getSharedPreferenceData==null){
                    startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                }
                else{
                    if (getSharedPreferenceData.equals("first")){
                        startActivity(new Intent(SplashScreen.this,MainActivity.class));
                    }
                    else if(getSharedPreferenceData.equals("second")){
                        startActivity(new Intent(SplashScreen.this,SecondActivity.class));
                    }
                    else if(getSharedPreferenceData.equals("third")){
                        startActivity(new Intent(SplashScreen.this,ThirdActivity.class));
                    }
                }
                // close this activity
                SplashScreen.this.finish();

                //Apply Animation to transition between Splash and Main Activity
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        }, SPLASH_TIME_OUT);
    }

}
