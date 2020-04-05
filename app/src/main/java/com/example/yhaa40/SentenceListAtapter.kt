package com.example.yhaa40

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sentence_layout.view.*

class SentenceListAtapter(private var sentenceList: ArrayList<Sentence>) :
    RecyclerView.Adapter<SentenceListAtapter.SentenceViewHolder>() {

     fun updateSentenceList(newList:ArrayList<Sentence>){
         sentenceList.clear()
         sentenceList.addAll(newList)
         notifyDataSetChanged()
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SentenceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.sentence_layout, parent, false)
        return SentenceViewHolder(view)
    }

    override fun getItemCount() = sentenceList.size

    override fun onBindViewHolder(holder: SentenceViewHolder, position: Int) {
        holder.view.sentenceTextView.text = sentenceList[position].sentenceText
        holder.view.explainTextView.text = sentenceList[position].explainText
    }

    class SentenceViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}