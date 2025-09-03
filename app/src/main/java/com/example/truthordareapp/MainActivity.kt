package com.example.truthordareapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerNames = mutableListOf<String>()

        val etPlayerName = findViewById<EditText>(R.id.etPlayerName)
        val btnStart = findViewById<Button>(R.id.startGameBtn)
        val btnAddPlayer = findViewById<Button>(R.id.addPlayerBtn)
        val playerListView = findViewById<ListView>(R.id.playerListView)

        btnAddPlayer.setOnClickListener {
            val playerName = etPlayerName.text.toString()
            println("MAIN_ACTIVITY: Player Name: $playerName")
            Toast.makeText(this, "Player added: $playerName", Toast.LENGTH_SHORT).show()
            playerNames.add(playerName)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, playerNames)
            playerListView.adapter = adapter
            etPlayerName.text.clear()
        }

        btnStart.setOnClickListener {
            val playerName = etPlayerName.text.toString()
            println("MAIN_ACTIVITY: Player Name: $playerName")
            val intent = Intent(this, GameActivity:: class.java)
            intent.putExtra("PLAYERS", ArrayList(playerNames))
            startActivity(intent)
        }
    }
}
