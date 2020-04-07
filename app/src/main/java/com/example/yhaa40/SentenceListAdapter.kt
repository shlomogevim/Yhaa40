package com.example.yhaa40

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sentence_layout.view.*


class SentenceListAdapter(val context: Context,private var sentenceList: ArrayList<Sentence>) :
    RecyclerView.Adapter<SentenceListAdapter.SentenceViewHolder>() {


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

        val params=ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 130, 0, 0)
        vi2.setLayoutParams(params)

       /* val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        params.setMargins(10, 10, 10, 10)
        vi2.setLayoutParams(params)*/





    }

    class SentenceViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}
/*

        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, talker.textSize)
        val font = pref.getFonts()
        tv.typeface = helper.getTypeFace(font)

        tv.setPadding(talker.padding[0], talker.padding[1], talker.padding[2], talker.padding[3])

        //   tv.setPadding(40, 40, 40, 40)
        tv.text = st.trim()

        return tv
    }*/