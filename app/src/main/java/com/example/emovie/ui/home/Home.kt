package com.example.emovie.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.emovie.R
import com.example.emovie.data.model.Option
import com.example.emovie.databinding.ActivityHomeBinding
import com.example.emovie.ui.internal.Internal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    val viewModel: HomeViewModel by viewModels()
    lateinit var adapterUpComing: AdapteListMovies
    lateinit var adapterTopRated: AdapteListMovies
    lateinit var adapterRecommendation: AdapteList2Movies


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterUpComing = AdapteListMovies(arrayListOf()) {
            startActivity(
                Intent(this, Internal::class.java)
                    .putExtra("id", it.id)
            )
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out)
        }
        adapterTopRated = AdapteListMovies(arrayListOf()) {
            startActivity(
                Intent(this, Internal::class.java)
                    .putExtra("id", it.id)
            )
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out)
        }
        adapterRecommendation = AdapteList2Movies(arrayListOf()) {
            startActivity(
                Intent(this, Internal::class.java)
                    .putExtra("id", it.id)
            )
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        }
        binding.recyclerView.adapter = adapterUpComing
        binding.recyclerView2.adapter = adapterTopRated
        binding.gridView.layoutManager = GridLayoutManager(this, 2)
        binding.gridView.adapter = adapterRecommendation
        viewModel.listUpComing.observe(this) {
            adapterUpComing.setData(it)
        }
        viewModel.listTopRated.observe(this) {
            adapterTopRated.setData(it)
            viewModel.setCategory(Option.japones)
        }

        viewModel.listRecommended.observe(this){
            adapterRecommendation.setData(it)
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.jp ->{
                   viewModel.setCategory(Option.japones)
                }
                R.id.year->{
                   viewModel.setCategory(Option.years2020)
                }

            }
        }
    }
}