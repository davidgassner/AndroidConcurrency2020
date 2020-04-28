package com.example.androidconcurrency2020

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidconcurrency2020.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageViews: Array<ImageView>
    private val drawables = arrayOf(
        R.drawable.die_1, R.drawable.die_2,
        R.drawable.die_3, R.drawable.die_4,
        R.drawable.die_5, R.drawable.die_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageViews = arrayOf(binding.die1, binding.die2, binding.die3, binding.die4, binding.die5)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.dieValue.observe(this, Observer {
            imageViews[it.first].setImageResource(drawables[it.second - 1])
        })

        binding.rollButton.setOnClickListener { viewModel.rollTheDice() }

    }

}
