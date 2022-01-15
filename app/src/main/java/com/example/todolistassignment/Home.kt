package com.example.todolistassignment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistassignment.adapters.SelectedUser
import com.example.todolistassignment.adapters.rvUserListAdapter
import com.example.todolistassignment.databinding.ActivityHomeBinding


class Home : AppCompatActivity(){

    lateinit var binding: ActivityHomeBinding
    private lateinit var sharedprefedit: SharedPreferences.Editor
    private var isNightModeOn: Boolean = false
    private lateinit var appSettingPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nightModeSetUp()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val switchItem = menu?.findItem(R.id.mi_Dark_mode)
        val Darkkmode = switchItem?.actionView as SwitchCompat

        Darkkmode.setOnClickListener {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedprefedit.putBoolean("NightMode", false)
                sharedprefedit.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedprefedit.putBoolean("NightMode", true)
                sharedprefedit.apply()
                Toast.makeText(this, "Night Mode activated", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onCreateOptionsMenu(menu)
    }

    private fun nightModeSetUp() {
        appSettingPrefs = getSharedPreferences("darkModeSettings", AppCompatActivity.MODE_PRIVATE)
        sharedprefedit = appSettingPrefs.edit()
        isNightModeOn = appSettingPrefs.getBoolean("NightMode", false)

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

    }

}