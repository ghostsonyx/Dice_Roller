package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val rollResult = rollDice()
            showRollResultOutput(rollResult)
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(): Int {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        return diceRoll;
    }

    private fun showRollResultOutput(rollResult: Int) {
        val drawableResource = when(rollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.ic_launcher_background}
        }

        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = rollResult.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}