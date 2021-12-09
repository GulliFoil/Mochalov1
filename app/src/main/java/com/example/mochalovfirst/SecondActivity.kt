package com.example.mochalovfirst

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_DENIED
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

private const val hello_key = "Это передача данных"

class SecondActivity : AppCompatActivity() {
    private val PermissionsRequestCode = 123
    private lateinit var managePermissions: ManagePermissions
    lateinit var motherActivityButton: Button
    lateinit var fromFirstActivityText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val list = listOf<String>(
            //Manifest.permission.CAMERA,
            //Manifest.permission.READ_CONTACTS,
            //Manifest.permission.READ_EXTERNAL_STORAGE,
            //Manifest.permission.SEND_SMS,
            //Manifest.permission.READ_CALENDAR,
            Manifest.permission.CALL_PHONE
        )
        // Initialize a new instance of ManagePermissions class
        managePermissions = ManagePermissions(this, list, PermissionsRequestCode)

        fromFirstActivityText = findViewById(R.id.text_second_screen)
        val textHTR: String? = intent.extras?.getString(hello_key, "")
        fromFirstActivityText.text = textHTR

        motherActivityButton = findViewById(R.id.call_father_activity)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if( PERMISSION_DENIED!=0)
                managePermissions.checkPermissions()
        }


        motherActivityButton.setOnClickListener {

            val intentmother = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+79159817345"))
            startActivity(intentmother)
            // Function to check and request permission.
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PermissionsRequestCode -> {
                val isPermissionsGranted = managePermissions
                    .processPermissionsResult(requestCode, permissions, grantResults)

                if (isPermissionsGranted) {
                    // Do the task now
                    toast("Permissions granted.")
                } else {
                    toast("Permissions denied.")
                }
                return
            }
        }
    }
}


// Extension function to show toast message
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}









