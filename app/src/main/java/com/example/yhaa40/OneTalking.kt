package com.example.yhaa40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OneTalking : AppCompatActivity() {
    var numTalking=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_talking)

        numTalking=intent.getIntExtra("TalkNum",1)
    }
}
