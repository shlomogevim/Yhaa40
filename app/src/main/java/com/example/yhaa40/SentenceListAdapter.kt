package com.example.yhaa40

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sentence.view.*
import kotlinx.android.synthetic.main.sentence_layout.view.*


class SentenceListAdapter(val context: Context,private var sentenceList: ArrayList<Sentence>) :
    RecyclerView.Adapter<SentenceListAdapter.SentenceViewHolder>() {
 var pref=GetAndStoreData(context)


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

        holder.view.firstSenTV.text = sentenceList[position].firstPartSen
        holder.view.secondSenTV.text = sentenceList[position].secondPartSen
        setSentenceStyle(holder,position)
        pref.saveCurrentePost(position)
        holder.view.flowerPostIV.setOnClickListener {
            val intent=Intent(context, YoutubActivity::class.java)
            intent.putExtra("postnum",position)
            context.startActivity(intent)


        }
    }

    private fun setSentenceStyle(holder: SentenceListAdapter.SentenceViewHolder, position: Int) {
        val vi=holder.view.firstSenTV
       vi.setTextColor(Color.parseColor("#ffff5a")) //yellow
        vi.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 20f)
        val helper=Helper(context)
        vi.typeface=helper.getTypeFace(1)
        vi.setLineSpacing(1.0f,1.0f)

        val vi2=holder.view.secondSenTV
        vi2.setTextColor(Color.parseColor("#ffff5a")) //yellow
        vi2.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 24f)
        vi2.typeface=helper.getTypeFace(13)
        vi2.setLineSpacing(1.3f,1.3f)

        val params= LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 30.toPx(), 0, 0)
        vi2.setLayoutParams(params)
    }

    fun Int.toPx()=(this*Resources.getSystem().displayMetrics.density).toInt()

    class SentenceViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}
