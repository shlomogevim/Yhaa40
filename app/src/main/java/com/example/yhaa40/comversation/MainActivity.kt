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
    lateinit var pref: GetAndStoreData
    private var adapter: ConversationAdapter? = null
    private var conversationList: ArrayList<Conversation>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*val talkNum = 0
        when (talkNum){
            -1-> setSpesialTalk(talkNum)
          //  -2->activateList()
            else->activateList()

        }*/
       val talkNum = -1

        if (talkNum==-1){
            activateList()
        }
       if (talkNum in 0..99) {
           setSpesialTalk(talkNum)
       }


    }

    private fun activateList() {
      conversationList = ArrayList<Conversation>()
       Helper.Page.createConverList()
        conversationList=Helper.Page.conversList

        layoutManager = LinearLayoutManager(this)
        adapter = ConversationAdapter(this, conversationList!!)
           // ConversationAdapter(this, conversationList!!)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

      /*  for (i in 0..91) {
            val preson = Conversation(
                "Mami" + i.toString(),
                (40 + i).toString()
            )
            conversationList!!.add(preson)
        }*/

        adapter!!.notifyDataSetChanged()
    }

    private fun setSpesialTalk(talkNum: Int) {
        val intent= Intent(this, OneTalking::class.java)
        intent.putExtra("TalkNum",talkNum)
        startActivity(intent)
    }
}

