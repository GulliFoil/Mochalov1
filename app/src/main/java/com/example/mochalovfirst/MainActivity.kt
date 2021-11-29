package com.example.mochalovfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var hellowTextView : TextView
    lateinit var newTextButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hellowTextView = findViewById(R.id.text_view)
        newTextButton = findViewById(R.id.new_text_button)
        newtextbuttonClick()

    }

    fun newtextbuttonClick() {
        newTextButton.setOnClickListener {
            hellowTextView.text = Random.nextInt().toString()
        }
    }
}