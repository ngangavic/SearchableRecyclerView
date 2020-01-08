package com.example.searchablerecyclerview.kotlin

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchablerecyclerview.R

class AnimalHolder (itemView: View, private val animalObject: List<Animal>) :
        RecyclerView.ViewHolder(itemView){
    var name: TextView
    var location: TextView
    var imageView: ImageView

    init {
        name = itemView.findViewById(R.id.textViewName) as TextView
        location = itemView.findViewById(R.id.textViewLocation) as TextView
        imageView = itemView.findViewById(R.id.imageView) as ImageView
    }
}
