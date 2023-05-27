package com.whiskey.alertsys

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class DetailsViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_view)

        val videoView:VideoView = findViewById(R.id.video_view);
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)


        val uri:Uri = Uri.parse("android.resource://$packageName/${R.raw.acci}")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        var mapsbtn = findViewById<Button>(R.id.navigate_button)
        mapsbtn.setOnClickListener {
            val uriGeo:Uri = Uri.parse("geo:8.5581,76.8816?z=12&q=8.5581,76.8816")
            val locationIntent = Intent(Intent.ACTION_VIEW, uriGeo)
            locationIntent.setPackage("com.google.android.apps.maps")
            locationIntent.resolveActivity(packageManager)
            startActivity(locationIntent)
        }

    }
}