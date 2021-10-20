package com.example.dhc.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.example.dhc.R
import kotlinx.android.synthetic.main.activity_main.*

class GuidanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guidance)

        // Remove back button and logo
        setSupportActionBar(toolbar);
        supportActionBar!!.setDisplayShowTitleEnabled(false);
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        var closeBtn: ImageView = findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener{
            finish()
        }
    }


    /**
     * Inflate the menu for this fragment
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    /**
     * Handle action bar item clicks here. The action bar will
     * automatically handle clicks on the Home/Up button, so long
     * as you specify a parent activity in AndroidManifest.xml.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.getItemId() == R.id.action_help) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
