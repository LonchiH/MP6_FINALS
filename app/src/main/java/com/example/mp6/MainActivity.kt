package com.example.mp6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private val data = mutableListOf<String>()
    private val fragmentList = ArrayList<Fragment>()
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castView()
        addToList()
        fragmentList.add(Frag1())
        fragmentList.add(Frag2())
        fragmentList.add(Frag3())

        viewPager.adapter = ViewPagerFragmentAdapter(this, fragmentList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        indicator.setViewPager(viewPager)

        var skipBtn = findViewById<Button>(R.id.skipBtn)
        skipBtn.setOnClickListener{
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun castView() {

        viewPager = findViewById(R.id.view_pager2)
        indicator = findViewById(R.id.indicator)

    }

    private fun addToList() {
        for (item in 1..3) {
            data.add("item $item")
        }
    }
}