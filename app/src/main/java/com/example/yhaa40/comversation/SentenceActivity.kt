package com.example.yhaa40.comversation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yhaa40.*
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.activity_sentence.*
import kotlinx.android.synthetic.main.activity_sentence.view.*

class SentenceActivity (): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)
        operateSenRecyclerView()
        rearrangeRecyclerView()
        //this.finish()
    }

    private fun rearrangeRecyclerView() {

        val currentPosition=recyclerViewPostId.computeHorizontalScrollOffset()
        Log.i("clima","SentenceActivity->currentPosition is ->$currentPosition")

    }

    fun operateSenRecyclerView() {
        var senteList = ArrayList<Sentence>()
        Helper.Sent.createSentList()
        senteList = Helper.Sent.sentList
        val snapeHelper = GravitySnapHelper(Gravity.CENTER)

        recyclerViewPostId.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        snapeHelper.attachToRecyclerView(recyclerViewPostId)
        recyclerViewPostId.adapter = SentenceListAdapter(this,senteList)
        recyclerViewPostId.adapter!!.notifyDataSetChanged()
    }

}
