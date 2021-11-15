package com.example.testsecondtry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var btBrowse: Button
    private lateinit var btLocalDB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btBrowse = findViewById(R.id.btBrowse)
        btLocalDB = findViewById(R.id.btLocalDB)

        btBrowse.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,BrowserFragment()).commit()
        }
        btLocalDB.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,FavoriteFragment()).commit()
        }
    }
}
