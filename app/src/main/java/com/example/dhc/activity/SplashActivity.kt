package com.example.dhc.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dhc.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // check shared preference
        val sharedPref=
            getSharedPreferences("INSTALLED", Context.MODE_PRIVATE)
        val installationFlag: Boolean? =
            sharedPref.getBoolean("INSTALLATION_FLAG", false)

        if (installationFlag!!) {
            //start main activity
            //finish this activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else {
            //a second splash time
            Handler().postDelayed({
                //start service intro activity
                //finish this activity
                startActivity(Intent(this, ServiceIntroActivity::class.java))
                finish()
            },1000)
        }
    }
}