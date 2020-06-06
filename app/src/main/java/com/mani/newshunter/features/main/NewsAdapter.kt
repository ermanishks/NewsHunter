package com.mani.newshunter.features.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mani.domain.entities.model.ArticlesVO
import com.mani.newshunter.databinding.ItemHeadlineNewsBinding

/**
 * Created by Manish Kumar
 */
class NewsAdapter(private val lifecycleOwner: LifecycleOwner):ListAdapter<ArticlesVO, NewsViewHolder>(NewsDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemHeadlineNewsBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ).apply {

        }
        return  NewsViewHolder(binding,lifecycleOwner)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val itemVo = getItem(position)
         holder.bind(itemVo)
    }
}
class NewsViewHolder(private val binding: ItemHeadlineNewsBinding,
                     private val lifecycleOwner: LifecycleOwner): RecyclerView.ViewHolder(binding.root) {
    fun bind(articlesVO: ArticlesVO){
        binding.model = articlesVO
        binding.lifecycleOwner= lifecycleOwner
        binding.executePendingBindings()
    }
}
object NewsDiff : DiffUtil.ItemCallback<ArticlesVO>() {
    override fun areItemsTheSame(oldItem: ArticlesVO, newItem: ArticlesVO): Boolean {
        Log.d("MANISH"," ${oldItem.title}   new title  ${newItem.title}")
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticlesVO, newItem: ArticlesVO): Boolean {
        Log.d("MANISH"," dfdfdf   ${oldItem.title}   new title  ${newItem.title}")
        return oldItem == newItem
    }
}
