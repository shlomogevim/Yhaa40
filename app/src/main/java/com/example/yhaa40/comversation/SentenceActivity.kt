package com.example.yhaa40.comversation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yhaa40.Helper
import com.example.yhaa40.R
import com.example.yhaa40.Sentence
import com.example.yhaa40.SentenceListAtapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sentence.*

class SentenceActivity : AppCompatActivity() {
     var sentList=ArrayList<Sentence>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)
        Helper.Sent.createSentList()
        sentList=Helper.Sent.sentList

        recyclerViewPostId.layoutManager=
                    LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewPostId.adapter=SentenceListAtapter(sentList)
        recyclerViewPostId.adapter!!.notifyDataSetChanged()
    }
}
