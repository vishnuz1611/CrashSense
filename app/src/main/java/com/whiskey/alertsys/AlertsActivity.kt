package com.whiskey.alertsys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AlertsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alerts)

        var showVid = findViewById<Button>(R.id.show_vid)
        showVid.setOnClickListener{
            val intent = Intent(this, DetailsViewActivity::class.java)
            startActivity(intent)
        }
    }
}