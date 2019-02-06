package com.gm.recyclerviewadaptermerge.model

import com.gm.recyclerviewadaptermerge.Constants
import com.gm.recyclerviewadaptermerge.util.ViewType

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 05/02/19.
 */
data class Article(
    val section: String, val subsection: String, val title: String, val abstract: String,
    val url: String, val byline: String, val item_type: String, val updated_date: String
) : ViewType {
    override fun getViewType(): Int = Constants.NEWS
}