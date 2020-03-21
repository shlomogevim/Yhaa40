package com.example.yhaa40.comversation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yhaa40.GetAndStoreData
import com.example.yhaa40.OneTalking
import com.example.yhaa40.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var pref: GetAndStoreData
    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
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
        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter =
            PersonListAdapter(this, personList!!)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        for (i in 0..91) {
            val preson = Person(
                "Mami" + i.toString(),
                40 + i
            )
            personList!!.add(preson)
        }
        adapter!!.notifyDataSetChanged()
    }

    private fun setSpesialTalk(talkNum: Int) {
        val intent= Intent(this, OneTalking::class.java)
        intent.putExtra("TalkNum",talkNum)
        startActivity(intent)
    }
}

