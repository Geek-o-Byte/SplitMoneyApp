package com.example.mirimoney

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupListAdapter(private val grouplist: ArrayList<Group>): RecyclerView.Adapter<GroupListAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return grouplist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.group_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenties = grouplist[position]
        holder.groupName.text = currenties.groupName
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val groupName = itemView.findViewById<TextView>(R.id.groupName)
    }
}