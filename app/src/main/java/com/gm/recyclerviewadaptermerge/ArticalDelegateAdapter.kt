package com.gm.recyclerviewadaptermerge

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gm.recyclerviewadaptermerge.model.Article
import com.gm.recyclerviewadaptermerge.util.ViewType
import com.gm.recyclerviewadaptermerge.util.ViewTypeDelegateAdapter
import com.gm.recyclerviewadaptermerge.util.inflate
import kotlinx.android.synthetic.main.item_article.view.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 05/02/19.
 */
class ArticalDelegateAdapter(val viewActions: OnViewSelectedListener) : ViewTypeDelegateAdapter {

    interface OnViewSelectedListener {
        fun onItemSelected(url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as Article)
    }


    inner class NewsViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.item_article)) {

        private val title = itemView.title
        private val subtitle = itemView.subtitle
        private val category = itemView.category

        fun bind(item: Article) {
            title.text = item.title
            subtitle.text = item.byline
            category.text = item.section

            super.itemView.setOnClickListener { viewActions.onItemSelected(item.url) }
        }
    }

}