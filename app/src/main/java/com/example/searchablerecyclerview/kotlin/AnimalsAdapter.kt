package com.example.searchablerecyclerview.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.searchablerecyclerview.R

class AnimalsAdapter(private var context: Context, private var animals: List<Animal>) :
        RecyclerView.Adapter<AnimalHolder>(), Filterable {
    private var animalListFiltered: List<Animal> = animals
    private val listener: AnimalsAdapterListener? = null

//    class AnimalsAdapter (private var context: Context, private val animals: ArrayList<Animal>) :
//            RecyclerView.Adapter<AnimalHolder>() , Filterable {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val viewHolder: AnimalHolder?
        val layoutView =
                LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        viewHolder = AnimalHolder(layoutView, animals)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        holder.name.text = animals[position].name
        holder.location.text = animals[position].location
        Glide.with(context).load(animals[position].img).apply(RequestOptions.circleCropTransform()).into(holder.imageView)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    animalListFiltered = animals
                } else {
                    val filteredList: MutableList<Animal> = java.util.ArrayList()
                    for (row in animals) { //charSequence.toString().toLowerCase();
                        if (row.name?.toLowerCase()?.contains(charSequence.toString().toLowerCase())!!) {
                            filteredList.add(row)
                        }
                    }
                    animalListFiltered = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = animalListFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                animalListFiltered = filterResults.values as java.util.ArrayList<Animal>
                notifyDataSetChanged()
            }
        }
    }

    interface AnimalsAdapterListener {
        fun onAnimalSelected(animal: Animal)
    }
}