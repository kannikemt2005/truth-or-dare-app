package com.example.truthordareapp // Ensure this matches your actual package name
//controller for your first screen
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.truthordare.GameActivity
import com.example.truthordare.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPlayerName = findViewById<EditText>(R.id.etPlayerName)
        val btnStart = findViewById<Button>(R.id.startGameBtn)

        btnStart.setOnClickListener {
            val playerName = etPlayerName.text.toString()

            val intent = Intent(this, GameActivity:: class.java)
            intent.putExtra("PLAYER_NAME", playerName)
            startActivity(intent)
        }
    }
}
