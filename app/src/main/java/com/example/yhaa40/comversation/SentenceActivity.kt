package com.example.yhaa40.comversation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yhaa40.Helper
import com.example.yhaa40.R
import com.example.yhaa40.Sentence
import com.example.yhaa40.SentenceListAtapter
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sentence.*

class SentenceActivity (): AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)
        operateSenRecyclerView()
    }

    fun operateSenRecyclerView() {
        var senteList = ArrayList<Sentence>()
        Helper.Sent.createSentList()
        senteList = Helper.Sent.sentList
        val snapeHelper = GravitySnapHelper(Gravity.CENTER)

        recyclerViewPostId.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        snapeHelper.attachToRecyclerView(recyclerViewPostId)
        recyclerViewPostId.adapter = SentenceListAtapter(senteList)
        recyclerViewPostId.adapter!!.notifyDataSetChanged()
    }
}
