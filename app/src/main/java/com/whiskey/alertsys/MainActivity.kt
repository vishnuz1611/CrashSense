package com.whiskey.alertsys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentUser = FirebaseAuth.getInstance().currentUser

        if(currentUser != null) {
            startActivity(Intent(this, AlertsActivity::class.java))
            finish()
        }

        var btnNext = findViewById<Button>(R.id.alert_btn)
        btnNext.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

//        val navigateButton: Button = findViewById(R.id.navigate_button)
//        navigateButton.setOnClickListener {
//            // Launch a map application with the accident location
//            val accidentLocation = Uri.parse("geo:0,0?q=latitude,longitude")
//            val mapIntent = Intent(Intent.ACTION_VIEW, accidentLocation)
//            mapIntent.setPackage("com.google.android.apps.maps") // Optionally, specify a specific map application
//            if (mapIntent.resolveActivity(packageManager) != null) {
//                startActivity(mapIntent)
//            }
//        }

    }
}