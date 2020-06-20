package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var rollButton: Button
    lateinit var rollUp: Button
    lateinit var reset: Button
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = (findViewById(R.id.btn_roll))
        rollUp = (findViewById(R.id.btn_roll_up))
        reset = (findViewById(R.id.btn_reset))
        diceImage = (findViewById(R.id.dice_image))
        resultText = (findViewById(R.id.result_text))

        rollButton.setOnClickListener { rollDice() }
        rollUp.setOnClickListener { rollUp() }
        reset.setOnClickListener { reset() }

    }

    private fun rollDice() {
        val randomNumber = (1..6).random()
        val drawableResource = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        resultText.text = randomNumber.toString()
    }

    private fun rollUp() {
        if (resultText.text == "Hello World") {
            resultText.text = "1"
        } else {
            var resultInt = resultText.text.toString().toInt()
            if (resultInt != 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }

        val drawableResource = when (resultText.text.toString().toInt()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    private fun reset() {
        resultText.text = "0"
        diceImage.setImageResource(R.drawable.empty_dice)
    }

}
