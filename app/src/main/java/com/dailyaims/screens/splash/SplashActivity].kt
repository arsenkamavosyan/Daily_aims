package com.dailyaims.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dailyaims.MainActivity
import com.dailyaims.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private final val SPLASH_DISPLAY_LENGTH = 3 * 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState)

        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}