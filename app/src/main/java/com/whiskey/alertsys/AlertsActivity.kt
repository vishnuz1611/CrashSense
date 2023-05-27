package com.whiskey.alertsys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth

class AlertsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alerts)

        var showVid = findViewById<Button>(R.id.show_vid)
        showVid.setOnClickListener{
            val intent = Intent(this, DetailsViewActivity::class.java)
            startActivity(intent)
        }

        var logoutBtn = findViewById<ImageView>(R.id.logout_icon)
        logoutBtn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
            finish()
        }
    }
}