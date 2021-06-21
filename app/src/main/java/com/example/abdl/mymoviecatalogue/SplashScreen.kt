package com.example.abdl.mymoviecatalogue

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.abdl.mymoviecatalogue.ui.home.HomeActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}