package com.texnopos.redbook.ui.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.texnopos.redbook.R
import com.texnopos.redbook.data.model.Animal
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalListAdapter : RecyclerView.Adapter<AnimalListAdapter.AnimalListViewHolder>() {

    var models: List<Animal> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalListViewHolder(itemView)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: AnimalListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    inner class AnimalListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(animal: Animal) {
            itemView.uzbName.text = animal.nameUzb
            itemView.rusName.text = animal.nameRus
            itemView.engName.text = animal.nameEng
            val imageResName = "picture${animal.id}"
            Glide
                .with(itemView)
                .load(itemView.context.resources.getIdentifier(imageResName, "drawable", itemView.context.packageName))
                .into(itemView.ivAnimal)
            }

    }
}