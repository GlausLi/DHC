package com.example.dhc.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dhc.R

class NotificationGuidanceActivity : AppCompatActivity() {

    private lateinit var nextBtn: TextView
    private lateinit var description: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_guidance)

        nextBtn = findViewById(R.id.nextBtn)
        nextBtn.setOnClickListener{

            // register to shared preference
            val sharedPref=
                getSharedPreferences("INSTALLED", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("INSTALLATION_FLAG", true)
            editor.commit()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        description = findViewById(R.id.description)
        description.text = getString(R.string.intro_notification_description)
//            .replace("", "\u00A0")
    }
}
