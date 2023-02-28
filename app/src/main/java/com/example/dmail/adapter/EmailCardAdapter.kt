package com.example.dmail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dmail.R
import com.example.dmail.data.DataSource

class EmailCardAdapter(
    private val context: Context?
): RecyclerView.Adapter<EmailCardAdapter.EmailCardViewHolder>(){

    private val dataset = DataSource.emails

    class EmailCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!){
        val textView1: TextView = view!!.findViewById(R.id.sender_name)
        val textView2: TextView = view!!.findViewById(R.id.subject)
        val textView3: TextView = view!!.findViewById(R.id.content)
        val button: Button = view!!.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return EmailCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: EmailCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView1.text = item.senderName
        holder.textView2.text = item.objectMail
        holder.textView3.text = item.contentMessage.substring(0,36) + "..."
        holder.button.text = item.senderName.substring(0,1)
    }

    override fun getItemCount(): Int = dataset.size
}