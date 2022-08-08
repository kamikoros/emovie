package com.example.emovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.emovie.core.App
import com.example.emovie.databinding.ItemList2MovieBinding
import com.example.emovie.domain.modulo.Movie

class AdapteList2Movies  internal constructor(var list: List<Movie>, var result: (movie:Movie) -> Unit ) :
    RecyclerView.Adapter<AdapteList2Movies.ViewHolder>() {


    inner class ViewHolder(val binding: ItemList2MovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemList2MovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.cove.let {
            val circularProgressDrawable = CircularProgressDrawable(App.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            Glide.with(App.contextApp())
                .load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
                .diskCacheStrategy( DiskCacheStrategy.AUTOMATIC )
                .skipMemoryCache(true)
                .placeholder(circularProgressDrawable)
                .into(it)
        }
        holder.binding.item.setOnClickListener {
            result(item)
        }
    }

    fun setData(list: List<Movie>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}