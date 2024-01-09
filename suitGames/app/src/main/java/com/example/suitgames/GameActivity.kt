package com.example.suitgames

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockImgButton: ImageButton
    lateinit var scissorsImgButton: ImageButton
    lateinit var paperImgButton: ImageButton
    lateinit var resultImgView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImgButton = findViewById(R.id.rockImgButton)
        scissorsImgButton = findViewById(R.id.scissorsImgButton)
        paperImgButton = findViewById(R.id.paperImgButton)
        resultImgView = findViewById(R.id.resultImageView)
    }

    private fun initListeners() {
        rockImgButton.setOnClickListener { startGame(option = "ROCK") }
        scissorsImgButton.setOnClickListener { startGame(option = "SCISSORS") }
        paperImgButton.setOnClickListener { startGame(option = "PAPER") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option, computerOption) -> resultImgView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImgView.setImageResource(R.drawable.win)
            else -> resultImgView.setImageResource(R.drawable.lose)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()
    }
}


