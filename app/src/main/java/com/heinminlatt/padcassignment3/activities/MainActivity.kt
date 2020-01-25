package com.heinminlatt.padcassignment3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.heinminlatt.padcassignment3.R
import com.heinminlatt.padcassignment3.fragments.FragmentMain
import com.heinminlatt.padcassignment3.fragments.FragmentSearch
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fragment_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ChangeFragment(FragmentMain.newInstance("Main", "Main"))
        nav_main.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {
                        ChangeFragment(FragmentMain.newInstance("Main", "Main"))
                        return true
                    }

                    R.id.action_search -> {
                        ChangeFragment(FragmentSearch.newInstance("Search", "Search"))
                        return true
                    }

                }
                return false
            }

        })




    }

    private fun ChangeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }
}
