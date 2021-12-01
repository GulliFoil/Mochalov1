package com.example.mochalovfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

const val Tag = "MainAktivity"
const val Key = "randomText"
class MainActivity : AppCompatActivity() {
    lateinit var randomTextView: TextView
    lateinit var randomButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomTextView = findViewById(R.id.random_text_view)
        randomButton = findViewById(R.id.random_button)
        if(savedInstanceState != null){
            randomTextView.text = savedInstanceState.getString(Key)
        }

        randomButton.setOnClickListener {
            randomize()
        }

    }

    fun randomize() {
        randomTextView.text = Random.nextInt(until = 100).toString()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Key,randomTextView.text.toString())
    }


}