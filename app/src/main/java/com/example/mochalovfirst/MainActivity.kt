package com.example.mochalovfirst

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val hello_key = "Это передача данных"

class MainActivity : AppCompatActivity() {


    lateinit var nextActivityButton: Button
    lateinit var browserActivityButton: Button
    lateinit var instaActivityButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        nextActivityButton = findViewById(R.id.next_screen_activity)
        browserActivityButton = findViewById(R.id.browser_activity)
        instaActivityButton = findViewById(R.id.insta_activity)


        nextActivityButton.setOnClickListener {
            val secondActivityIntent: Intent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra(hello_key, null as String?)
            startActivity(secondActivityIntent)

        }
        browserActivityButton.setOnClickListener {
            val browser_link = Uri.parse("http://yandex.ru")
            val browserActivityIntent: Intent = Intent(Intent.ACTION_VIEW, browser_link)
            val chooser = Intent.createChooser(browserActivityIntent,"Browser")
            startActivity(browserActivityIntent)


        }
        instaActivityButton.setOnClickListener {
            val uri = Uri.parse("http://instagram.com")
            val insta: Intent = Intent(Intent.ACTION_VIEW, uri)
            insta.setPackage("com.instagram.android")
            startActivity(insta);

        }


    }


}