package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_list_item.view.*

class RecyclerViewAdapter(imageNames: List<String>, images: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG = "RecyclerViewAdapter"
    private var imageNames: List<String> = imageNames
    private var images: List<String> = images



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called")

        when (holder) {
            is ViewHolder -> {
                Glide.with(holder.context)
                    .asBitmap()
                    .load(images[position])
                    .into(holder.image)
                holder.imageName.text = imageNames[position]
                holder.itemView.setOnClickListener {
                    Log.d(TAG, "onclick: clicked on " + imageNames[position])
                    Toast.makeText(holder.context, imageNames[position], Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return imageNames.size
    }

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.circle_imageView
        val imageName = itemView.image_name
        var context = itemView.context

    }

}