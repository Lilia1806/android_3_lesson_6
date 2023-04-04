package com.example.android_3_lesson_6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_3_lesson_6.base.BaseDiffUtilItemCallback
import com.example.android_3_lesson_6.databinding.ItemNewsBinding
import com.example.android_3_lesson_6.extension.setImage
import com.example.android_3_lesson_6.models.ArticlesItemModel

class NewsAdapter : PagingDataAdapter<ArticlesItemModel, NewsAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {

    class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ArticlesItemModel?) = with(binding) {
            img.setImage(item?.urlToImage.toString())
            author.text = item?.author
            publishedAt.text = item?.publishedAt
            desc.text = item?.description
            title.text = item?.title
            source.text = item?.source?.name
            time.text = item?.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem((position)))
    }
}