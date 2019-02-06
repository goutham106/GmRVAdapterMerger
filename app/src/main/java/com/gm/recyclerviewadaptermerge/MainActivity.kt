package com.gm.recyclerviewadaptermerge

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gm.recyclerviewadaptermerge.model.Article
import com.gm.recyclerviewadaptermerger.RecyclerViewMergeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ArticalDelegateAdapter.OnViewSelectedListener {

    val baseRecyclerviewAdapter = RecyclerViewMergeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateArtical()

        recyclerView.apply {
            adapter = baseRecyclerviewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)

        }
    }

    private fun generateArtical() {
        val adapter = Adapter1(this)
        val list: MutableList<Article> = mutableListOf()

        for (i in 1..10) {
            val article = Article("A", "AB", "Gm", "Dont Know", "www.google.com", "---ha---", "type", "10-10-1000")
            list.add(article)
        }

        adapter.addArticles(list)

        baseRecyclerviewAdapter.addAdapter(adapter)
    }

    override fun onItemSelected(url: String) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show()
    }

}
