package com.example.emovie.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.emovie.ui.home.Home
import com.example.emovie.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(mainLooper).postDelayed({
            val i = Intent(this, Home::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            finish()
        }, 1500)
    }
}