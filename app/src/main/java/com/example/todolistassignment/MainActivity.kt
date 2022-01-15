package com.example.todolistassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todolistassignment.adapters.ViewPagerAdapter
import com.example.todolistassignment.databinding.ActivityMainBinding
import com.example.todolistassignment.fragments.LoginFragment
import com.example.todolistassignment.fragments.SignUpFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPagerInit()
    }

    private fun viewPagerInit() {

        val tabLayout = binding.tlTabLayout
        val viewpager = binding.vpViewpager
        val tabNamesArray = arrayListOf("Sign Up", "Sign in")
        val fragmentArray = arrayListOf(SignUpFragment(), LoginFragment())
        val adapter = ViewPagerAdapter(fragmentArray, this)

        viewpager.adapter = adapter
        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = tabNamesArray[position]
        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

//                tabLayout.setSelectedTabIndicator(R.drawable.bground)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


    }

}