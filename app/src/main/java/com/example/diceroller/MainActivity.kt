package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val luckyNumber = 4
            when (rollDice()) {
                luckyNumber -> Toast.makeText(this, "You are win!", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this, "You only get 1, not lucky enough!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Only get 2 from this roll, try again!", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "You got 3, too small thoug!", Toast.LENGTH_SHORT).show()
                5 -> Toast.makeText(this, "Good job! but not enough yet!", Toast.LENGTH_SHORT).show()
                6 -> Toast.makeText(this, "Congrats you are got Extra Point!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun rollDice(): Int {
        val dice = Dice(6)
        val result = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = result.toString()
        return result
    }
}


class Dice(private val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}
