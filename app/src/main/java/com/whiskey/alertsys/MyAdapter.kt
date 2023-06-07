package com.whiskey.alertsys

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val accidentList : ArrayList<Accident>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_acc_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = accidentList[position]

        holder.date.text = currentItem.date
        holder.time.text = currentItem.time
        holder.place.text = currentItem.place
        holder.video.text = currentItem.video
        holder.bind(currentItem)

    }


    override fun getItemCount(): Int {
        return accidentList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.date)
        val time: TextView = itemView.findViewById(R.id.timeAcc)
        val place: TextView = itemView.findViewById(R.id.placeAcc)
        val viewaccident: ImageView = itemView.findViewById(R.id.viewAcc)
        private val latitude = 6.08443
        private val longitude = -59.70389
        val video: TextView = itemView.findViewById(R.id.video_acc)

        private var currentItem: Accident? = null

        init {
            viewaccident.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, AccPlayerActivity::class.java)
                currentItem?.let { item ->
                    intent.putExtra("Date", item.date)
                    intent.putExtra("Time", item.time)
                    intent.putExtra("Place", item.place)
                    intent.putExtra("Long", longitude)
                    intent.putExtra("Lat", latitude)
                    intent.putExtra("Vid", item.video)
                    context.startActivity(intent)
                }
            }
        }

        fun bind(accident: Accident) {
            currentItem = accident
            date.text = accident.date
            time.text = accident.time
            place.text = accident.place
            video.text = accident.video
        }
    }
}