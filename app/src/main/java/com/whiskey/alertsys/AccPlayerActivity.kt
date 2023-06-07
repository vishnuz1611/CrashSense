package com.whiskey.alertsys

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.whiskey.alertsys.databinding.ActivityAccPlayerBinding
import java.net.URL

class AccPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccPlayerBinding
    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAccPlayerBinding.inflate(layoutInflater)
        val view = binding.flRoot
        setContentView(view)

        val date = intent.getStringExtra("Date")
        val time = intent.getStringExtra("Time")
        val place = intent.getStringExtra("Place")
        val longitude = intent.getDoubleExtra("Long",0.0)
        val latitude = intent.getDoubleExtra("Lat",0.0)
        val videoUri = intent.getStringExtra("Vid")

        findViewById<TextView>(R.id.dateIn).text = date
        findViewById<TextView>(R.id.placeAccIn).text = place
        findViewById<TextView>(R.id.timeIn).text = time
        findViewById<TextView>(R.id.latitudeIn).text = latitude.toString()
        findViewById<TextView>(R.id.longitudeIn).text = longitude.toString()

        preparePlayer(videoUri.toString())

        var mapsbtn = findViewById<Button>(R.id.navigate_button)
        mapsbtn.setOnClickListener {
            val uriGeo:Uri = Uri.parse("geo:$latitude,$longitude?z=12&q=$latitude,$longitude")
            val locationIntent = Intent(Intent.ACTION_VIEW, uriGeo)
            locationIntent.setPackage("com.google.android.apps.maps")
            locationIntent.resolveActivity(packageManager)
            startActivity(locationIntent)
        }
    }



    private fun preparePlayer(videoUri: String) {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer?.playWhenReady = true
        binding.playerView.player = exoPlayer
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        val mediaItem = MediaItem.fromUri(videoUri)
        val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.seekTo(playbackPosition)
        exoPlayer?.playWhenReady = playWhenReady
        exoPlayer?.prepare()
    }

    private fun releasePlayer() {
        exoPlayer?.let { player ->
            playbackPosition = player.currentPosition
            playWhenReady = player.playWhenReady
            player.release()
            exoPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }

    companion object{
        const val URL = "https://firebasestorage.googleapis.com/v0/b/alertsys-4227d.appspot.com/o/videos%2Facc1.mp4?alt=media&token=735c0f2f-e983-4dd1-8808-dff4e72ae448"
    }
}