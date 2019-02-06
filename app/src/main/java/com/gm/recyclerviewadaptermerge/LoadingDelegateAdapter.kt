package com.gm.recyclerviewadaptermerge

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gm.recyclerviewadaptermerge.util.ViewType
import com.gm.recyclerviewadaptermerge.util.ViewTypeDelegateAdapter
import com.gm.recyclerviewadaptermerge.util.inflate

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 05/02/19.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    inner class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.item_loading)
    )
}