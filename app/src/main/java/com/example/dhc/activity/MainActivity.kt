package com.example.dhc.activity

import MainViewPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.dhc.R
import com.example.dhc.pref.PrefsHelper
import com.example.dhc.viewmodel.ComponentViewModel
import com.example.dhc.viewmodel.CustomerViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar);
        supportActionBar!!.setDisplayShowTitleEnabled(false);

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        registerUser()

        pager.adapter = MainViewPagerAdapter(supportFragmentManager,this)
        tab_layout.setupWithViewPager(pager)
        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_home)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_buy)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_setting)
    }

    override fun onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    fun registerUser() {
        var prefs = PrefsHelper(this)

        if (prefs.firstName == null || prefs.firstName == "") {
            var viewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java)
            viewModel.customerUuid.observe(this, androidx.lifecycle.Observer {
                // Save UUID and First Name in Pref
                prefs.firstName = "1"
                prefs.uuid = it
            })
            viewModel.errorMessage.observe(this, androidx.lifecycle.Observer {

            })

            // viewModel.registerCustomer(UUID.randomUUID().toString(), "1")
        }
    }

    fun shouldDisplayHomeUp() {
        //Enable Up button only  if there are entries in the back stack
        var adapter = pager.adapter as MainViewPagerAdapter
        val canGoBack = adapter.getRegisteredFragment(pager.currentItem).childFragmentManager.backStackEntryCount > 1
        supportActionBar!!.setDisplayHomeAsUpEnabled(canGoBack)
    }

    override fun onSupportNavigateUp(): Boolean {
        //This method is called when the up button is pressed. Just the pop back stack.
        var adapter = pager.adapter as MainViewPagerAdapter
        adapter.getRegisteredFragment(pager.currentItem).let {
            adapter.getRegisteredFragment(pager.currentItem).childFragmentManager.popBackStack()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id: Int = item.getItemId()
        if (id == R.id.action_help) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        var adapter = pager.adapter as MainViewPagerAdapter

        adapter.getRegisteredFragment(pager.currentItem).let {
            if (adapter.getRegisteredFragment(pager.currentItem).childFragmentManager.backStackEntryCount == 1) {
                finish()
            } else {
                adapter.getRegisteredFragment(pager.currentItem).childFragmentManager.popBackStack()
            }
        }
    }
}
