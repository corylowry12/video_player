package com.cory.video_player

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.cory.video_player.databinding.ActivityMainBinding
import android.widget.VideoView
import android.widget.MediaController

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = findViewById<VideoView>(binding.videoPlayer.id)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val uri:Uri = Uri.parse("android.resource://" + packageName + "/raw/test")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}