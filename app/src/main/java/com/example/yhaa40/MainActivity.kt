package com.example.yhaa40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(this, personList!!)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        for (i in 0..91) {
            val preson = Person("Mami" + i.toString(), 40 + i)
            personList!!.add(preson)
        }
        adapter!!.notifyDataSetChanged()
    }

}
/*
       *  recyclerView.layoutManager=layoutManager
       recyclerView.adapter=adapter

       for (i in 0..91){
           val preson=
               Person("Mami" + i.toString(), 40 + i)
           personList!!.add(preson)
       }
       adapter!!.notifyDataSetChanged()*/
