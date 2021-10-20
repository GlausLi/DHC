package com.example.dhc.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.dhc.R
import com.example.dhc.fragment.ServiceIntroFragment
import com.google.android.material.tabs.TabLayout

@Suppress("DEPRECATION")
class ServiceIntroActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabDots: TabLayout
    private lateinit var nextBtn: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_intro)

        viewPager = findViewById(R.id.viewPager)
        tabDots   = findViewById(R.id.tabDots)
        nextBtn   = findViewById(R.id.nextBtn)

        setupViewPager()

        nextBtn.setOnClickListener{
            val intent = Intent(this, PersonalInfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupViewPager() {

        val adapter = com.example.dhc.adapter.FragmentPagerAdapter(getSupportFragmentManager())

        var fragment: ServiceIntroFragment = ServiceIntroFragment.newInstance(R.drawable.service_intro_1,
            R.string.intro_service_title_1, R.string.intro_service_description_1
        )
        adapter.addFragemnt(fragment)

        fragment = ServiceIntroFragment.newInstance(R.drawable.service_intro_2,
            R.string.intro_service_title_2, R.string.intro_service_description_2
        )
        adapter.addFragemnt(fragment)

        fragment = ServiceIntroFragment.newInstance(R.drawable.service_intro_3,
            R.string.intro_service_title_3, R.string.intro_service_description_3
        )
        adapter.addFragemnt(fragment)

        fragment = ServiceIntroFragment.newInstance(R.drawable.service_intro_4,
            R.string.intro_service_title_4, R.string.intro_service_description_4
        )
        adapter.addFragemnt(fragment)

        viewPager.adapter = adapter
        viewPager.setOnPageChangeListener(viewPagerChangeListener)

        tabDots.setupWithViewPager(viewPager)
    }

    private var viewPagerChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            if (position < 3) {
                nextBtn.setText(R.string.intro_skip)
            }
            else {
                nextBtn.setText(R.string.intro_start)
            }

        }
    }
}
