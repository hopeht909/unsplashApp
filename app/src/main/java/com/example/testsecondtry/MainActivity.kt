package com.example.testsecondtry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    private lateinit var btBrowse: ImageView
    private lateinit var btLocalDB: ImageView
    private lateinit var btHome: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btBrowse = findViewById(R.id.btBrowse)
        btLocalDB = findViewById(R.id.btLocalDB)
        btHome = findViewById(R.id.btHome)

        btBrowse.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,BrowserFragment()).commit()
        }
        btLocalDB.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,FavoriteFragment()).commit()
        }
        btHome.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,HomeFragment()).commit()
        }
    }
}
