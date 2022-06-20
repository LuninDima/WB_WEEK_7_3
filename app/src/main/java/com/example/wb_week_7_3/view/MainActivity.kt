package com.example.wb_week_7_3.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.wb_week_7_3.R
import com.example.wb_week_7_3.databinding.ActivityMainBinding
import com.example.wb_week_7_3.view.favorite.FavoriteFragment
import com.facebook.drawee.backends.pipeline.Fresco
import com.example.wb_week_7_3.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Fresco.initialize(this)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_screen_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menu_favorite -> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .add(R.id.fragment_container, FavoriteFragment.newInstance())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}