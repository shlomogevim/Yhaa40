package com.example.yhaa40

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_row.view.*

class PersonListAdapter(private val personList:ArrayList<Person>):
    RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.list_row,parent,false )
        return ViewHolder(view)
    }
    override fun getItemCount()=personList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.name.text=personList[position].name
        holder.view.age.text=personList[position].age.toString()
    }
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view)
}

/*class ConverListAdapter(private val converList: ArrayList<Convers>) :
    RecyclerView.Adapter<ConverListAdapter.ConverHolder>() {
    val PREFIX="שיחה מספר:"
    fun updateConverList(newConverList: List<Convers>) {
        converList.clear()
        converList.addAll(newConverList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_talking_new, parent, false)
        return ConverHolder(view)

    }

    override fun getItemCount() = converList.size


    override fun onBindViewHolder(holder: ConverListAdapter.ConverHolder, position: Int) {
        if (position==0){
            holder.view.iv_ItemReka.setImageResource(R.drawable.sea)
            holder.view.iv_ItemReka.scaleType=CENTER_CROP

        }else{
            holder.view.iv_ItemReka.setImageResource(R.drawable.ic_launcher_background)
            holder.view.iv_ItemReka.scaleType=CENTER
        }
        holder.view.tv_talkNum.text=PREFIX+converList[position].numC
        holder.view.tv_talkTitle.text=converList[position].title
        holder.view.tv_description.text=converList[position].explanation
        holder.view.layout_itemList.setOnClickListener {
           // val action=ListTalkingDirections.actionToDetails(converList[position])
           // val action=ListFragmentDirections.actionToDetails(converList[position])
            val action=ListTalkingDirections.actionToDetails(converList[position])
            Navigation.findNavController(it).navigate(action)
        }

    }

    class ConverHolder(val view: View) : RecyclerView.ViewHolder(view)

}

/*
holder.view.animalLayout.setOnClickListener {
    val action=ListFragmentDirections.
        actionDetails(animalList[position])
    Navigation.findNavController(holder.view).navigate(action)
}*/


/*
class ConverListAdapter(private val converList: ArrayList<Conversation>) :
    RecyclerView.Adapter<ConverListAdapter.ConverHolder>() {

    fun updateConverList(newConverList: List<Conversation>) {
        converList.clear()
        converList.addAll(newConverList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_talkingt, parent, false)
        return ConverHolder(view)

    }

    override fun getItemCount() = converList.size


    override fun onBindViewHolder(holder: ConverListAdapter.ConverHolder, position: Int) {
        holder.view.tv_conNum.text = converList[position].numC.toString()
        holder.view.tv_ConvTitle.text = converList[position].title
        holder.view.tv_ConvExplantion.text = converList[position].explanation
    }

    class ConverHolder(val view: View) : RecyclerView.ViewHolder(view)

}*/*/