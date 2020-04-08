package com.example.yhaa40

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_youtub.*

class YoutubActivity : AppCompatActivity() {
    lateinit var pref: GetAndStoreData
    var postNum = 0

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtub)

        postNum = intent.getIntExtra("postnum", 100)


        webView.settings.javaScriptEnabled=true
        webView.loadUrl("https://www.youtube.com/watch?v=rAOqP68wVS8")
        this.finish()
    }


}

