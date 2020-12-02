package com.example.module_home.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.module_home.R

/**
 * 单独运行时承载fragment
 */
class MainActivity : AppCompatActivity() {
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val homeFragment = HomeFragment()
        transaction.add(R.id.fl_content, homeFragment)
        transaction.commit()
        val ft = fm.beginTransaction()
        ft.show(homeFragment)
        ft.commit()
    }


}