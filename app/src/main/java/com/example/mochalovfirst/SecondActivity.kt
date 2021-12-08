package com.example.mochalovfirst

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val hello_key = "Это передача данных"

class SecondActivity : AppCompatActivity() {
    lateinit var fatherActivityButton: Button
    lateinit var fromFirstActivityText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        fromFirstActivityText = findViewById(R.id.text_second_screen)
        val textHTR: String? = intent.extras?.getString(hello_key, "")
        fromFirstActivityText.text = textHTR
        fatherActivityButton = findViewById(R.id.call_father_activity)

        fatherActivityButton.setOnClickListener {
            val intentfather = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+79159817345"))
            startActivity(intentfather)


        }


    }
}