package com.example.truthordare

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private val truthQuestions = listOf(
        "What’s your biggest fear?",
        "Who was your first crush?",
        "What’s the most embarrassing thing you’ve done?"
    )

    private val dares = listOf(
        "Do 10 push-ups!",
        "Sing a song loudly!",
        "Dance for 30 seconds!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val tvPlayer = findViewById<TextView>(R.id.tvPlayer)
        val btnTruth = findViewById<Button>(R.id.btnTruth)
        val btnDare = findViewById<Button>(R.id.btnDare)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        // Get player name from MainActivity
        val playerName = intent.getStringExtra("PLAYER_NAME") ?: "Player"
        tvPlayer.text = "$playerName's Turn!"

        btnTruth.setOnClickListener {
            val randomTruth = truthQuestions[Random.nextInt(truthQuestions.size)]
            tvQuestion.text = "Truth: $randomTruth"
        }

        btnDare.setOnClickListener {
            val randomDare = dares[Random.nextInt(dares.size)]
            tvQuestion.text = "Dare: $randomDare"
        }
    }
}
