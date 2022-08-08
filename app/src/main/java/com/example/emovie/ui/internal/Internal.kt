package com.example.emovie.ui.internal

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.emovie.R
import com.example.emovie.databinding.ActivityInternalBinding
import com.example.emovie.domain.modulo.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Internal : AppCompatActivity() {
    lateinit var binding:ActivityInternalBinding
    val viewModel: InternalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.init(intent.extras)
        viewModel.detail.observe(this){
            visualizeData(it)
        }
        binding.goBack.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        }
        binding.button.setOnClickListener {
            viewModel.uploadVideo()
        }
        viewModel.video.observe(this){
            val uri = "https://www.youtube.com/watch?v=${it.key}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.putExtra("force_fullscreen", true)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    fun visualizeData(detail:Movie){
        binding.poster.let {
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w500/${detail.poster_path}")
                .diskCacheStrategy( DiskCacheStrategy.AUTOMATIC )
                .skipMemoryCache(true)
                .into(it)
        }
        binding.overview.text = detail.overview
        binding.title.text = detail.title
        binding.textYears.text = detail.release_date.split("-")[0]
        binding.textLanguage.text= detail.original_language
        binding.textAverage.text =  detail.vote_average
        binding.genres.text = viewModel.txtGenres(detail.genres)

    }
}