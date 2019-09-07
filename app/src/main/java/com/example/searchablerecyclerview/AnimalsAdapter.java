package com.example.searchablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private List<Animal> animalList;
    private List<Animal> animalListFiltered;
    private AnimalsAdapterListener listener;


    public AnimalsAdapter(Context context, List<Animal> animalList, AnimalsAdapterListener listener) {
        this.context = context;
        this.animalList = animalList;
        this.animalListFiltered = animalList;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if(charString.isEmpty()){
                    animalListFiltered=animalList;
                }else{
                    List<Animal> filteredList = new ArrayList<>();
                    for(Animal row:animalList){
                        if(row.getName().toLowerCase().contains(charSequence)){
                            filteredList.add(row);
                        }
                    }
                    animalListFiltered=filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = animalListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                animalListFiltered = (ArrayList<Animal> )filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Animal  animal = animalListFiltered.get(position);
        holder.name.setText(animal.getName());
        holder.location.setText(animal.getLocation());

    }

    @Override
    public int getItemCount() {
        return animalListFiltered.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,location;

        public MyViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.textViewName);
            location=view.findViewById(R.id.textViewLocation);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onAnimalSelected(animalListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }



    public interface AnimalsAdapterListener{
        void onAnimalSelected(Animal animal);
    }

}
