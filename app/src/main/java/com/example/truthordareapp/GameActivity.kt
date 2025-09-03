package com.example.truthordareapp

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

    private val players = mutableListOf<String>()

    private val playedCount = mutableMapOf<String, Int>()

    private var currentPlayerIndex: Int = 0

    private lateinit var tvPlayer: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var btnTruth: Button
    private lateinit var btnDare: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tvPlayer = findViewById(R.id.tvPlayer)
        tvQuestion = findViewById(R.id.tvQuestion)
        btnTruth = findViewById(R.id.btnTruth)
        btnDare = findViewById(R.id.btnDare)
        btnNext = findViewById(R.id.nextButton)

        val playerListFromIntent = intent.getStringArrayListExtra("PLAYERS")
        if (playerListFromIntent != null) {

            players.addAll(playerListFromIntent)
        }

        players.forEach {
            playedCount[it] = 0
        }

        btnTruth.setOnClickListener {
            val randomTruth = truthQuestions[Random.nextInt(truthQuestions.size)]
            tvQuestion.text = "Truth: $randomTruth"
        }

        btnDare.setOnClickListener {
            val randomDare = dares[Random.nextInt(dares.size)]
            tvQuestion.text = "Dare: $randomDare"
        }

        btnNext.setOnClickListener {
            nextPlayerTurn()
            tvQuestion.text = ""
        }

        nextPlayerTurn()
    }

    private fun nextPlayerTurn() {

        val currentPlayer = players[currentPlayerIndex]
        playedCount[currentPlayer] = playedCount.getOrDefault(currentPlayer, 0) + 1

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size

        val nextPlayer = players[currentPlayerIndex]

        tvPlayer.text = "$nextPlayer's Turn!"

        println("Played counts: $playedCount")


    }
}