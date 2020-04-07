package com.example.yhaa40.comversation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yhaa40.GetAndStoreData
import com.example.yhaa40.Helper
import com.example.yhaa40.OneTalking
import com.example.yhaa40.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // lateinit var pref: GetAndStoreData
    private var adapter: ConversationAdapter? = null
    private var conversationList: ArrayList<Conversation>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pref = GetAndStoreData(this)
        pref.saveFirstTalk(true)

        val talkNum = -2
        when (talkNum){
            -1->activateList()
            in 0..99->setSpesialTalk(talkNum)
            -2->activateWord()
        }
    }

    private fun activateWord() {
        val intent = Intent(this, OneTalking::class.java)
        intent.putExtra("TalkNum", 0)
        startActivity(intent)
    }

    private fun activateList() {
        conversationList = ArrayList<Conversation>()
        Helper.Page.createConverList()
        conversationList = Helper.Page.conversList

        layoutManager = LinearLayoutManager(this)
        adapter = ConversationAdapter(this, conversationList!!)
        recyclerViewTalkingId.layoutManager = layoutManager
        recyclerViewTalkingId.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    private fun setSpesialTalk(talkNum: Int) {
        val intent = Intent(this, OneTalking::class.java)
        intent.putExtra("TalkNum", talkNum)
        startActivity(intent)
    }
}

