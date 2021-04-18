package com.example.android_practice_8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_8.databinding.MeaningItemBinding
import com.example.android_practice_8.model.Lf

class AcronymAdapter : RecyclerView.Adapter<AcronymAdapter.AcronymViewHolder>() {

    private val dataSet = mutableListOf<Lf>()

    class AcronymViewHolder(private val binding: MeaningItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun loadMeaning(lf : Lf) = with(binding) {
            meaning = lf
            executePendingBindings() //this makes binding to run immediately instead of delaying it
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymViewHolder {
        val binding = MeaningItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AcronymViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        holder.loadMeaning(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun loadData(meanings : List<Lf>) {
        dataSet.clear()
        dataSet.addAll(meanings)
        notifyDataSetChanged()
    }
}