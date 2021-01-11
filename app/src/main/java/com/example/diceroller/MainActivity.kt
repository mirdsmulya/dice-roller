package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }


    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceNum = dice.roll()
        val luckyNumber = 4
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceNum) {
            luckyNumber -> diceImage.setImageResource(R.drawable.dice_4)
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        when (diceNum) {
            luckyNumber -> Toast.makeText(this, "You are win!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "You only get 1, not lucky enough!", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "Only get 2 from this roll, try again!", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, "You got 3, too small thoug!", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(this, "Good job! you have got 5, but not enough yet!", Toast.LENGTH_SHORT).show()
            6 -> Toast.makeText(this, "Congrats you are got Extra Point! cause you get 6!", Toast.LENGTH_SHORT).show()
        }
    }
}


class Dice(private val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}
