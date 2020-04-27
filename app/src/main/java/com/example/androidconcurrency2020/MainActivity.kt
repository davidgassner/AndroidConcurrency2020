package com.example.androidconcurrency2020

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidconcurrency2020.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener { rollTheDice() }

    }

    /**
     * Run some code
     */
    private fun rollTheDice() {

        val dice = arrayOf(binding.die1, binding.die2, binding.die3, binding.die4, binding.die5)
        val images = arrayOf(
            R.drawable.die_1,
            R.drawable.die_2,
            R.drawable.die_3,
            R.drawable.die_4,
            R.drawable.die_5,
            R.drawable.die_6
        )

        for (die in dice) {
            val dieNumber = getDie()
            die.setImageResource(images[dieNumber - 1])
        }

    }

    /**
     * Get a random number from 1 to 6
     */
    private fun getDie(): Int {
        return Random.nextInt(1, 7)
    }

}
