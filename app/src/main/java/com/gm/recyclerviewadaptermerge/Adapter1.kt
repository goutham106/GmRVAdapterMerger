package com.gm.recyclerviewadaptermerge

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.gm.recyclerviewadaptermerge.model.Article
import com.gm.recyclerviewadaptermerge.util.ViewType
import com.gm.recyclerviewadaptermerge.util.ViewTypeDelegateAdapter
import java.util.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 05/02/19.
 */
class Adapter1(private val listener: ArticalDelegateAdapter.OnViewSelectedListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = Constants.LOADING
    }

    init {
        delegateAdapters.apply {
            put(Constants.LOADING, LoadingDelegateAdapter())
            put(Constants.NEWS, ArticalDelegateAdapter(listener))
        }

        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items[position].getViewType()
    }

    fun addArticles(articles: List<Article>) {
        val initPosition = items.lastIndex
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        items.addAll(articles)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

}