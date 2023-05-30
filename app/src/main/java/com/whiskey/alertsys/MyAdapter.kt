package com.whiskey.alertsys

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val accidentList : ArrayList<Accident>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_acc_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = accidentList[position]

        holder.date.text = currentItem.date
        holder.time.text = currentItem.time
        holder.place.text = currentItem.place
    }

    override fun getItemCount(): Int {
        return accidentList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val date : TextView = itemView.findViewById(R.id.date)
        val time: TextView = itemView.findViewById(R.id.timeAcc)
        val place: TextView = itemView.findViewById(R.id.placeAcc)

    }
}