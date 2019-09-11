package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    //Initialize the UI and sets listeners
    private fun initViews() {
        btnHigher.setOnClickListener() { onHigherClick() }
        btnLower.setOnClickListener() { onLowerClick() }
        btnEquals.setOnClickListener() { onEqualClick() }
        updateUI()
    }

    //Update the UI to a new dice and lastThrow text
    private fun updateUI() {
        lastThrowTV.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> dice.setImageResource(R.drawable.dice1)
            2 -> dice.setImageResource(R.drawable.dice2)
            3 -> dice.setImageResource(R.drawable.dice3)
            4 -> dice.setImageResource(R.drawable.dice4)
            5 -> dice.setImageResource(R.drawable.dice5)
            6 -> dice.setImageResource(R.drawable.dice6)
        }
    }

    //Replaces the previous value with the current one and replaces the current dice with a new dice
    private fun rollDice() {
        lastThrow = currentThrow

        //The current throw will be a number between 1 and 6 (inclusive)
        currentThrow = (1..6).random()
        updateUI()
    }

    //Calls [rollDice] and checks if the answer is correct
    private fun onHigherClick() {
        rollDice()

        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    //Calls [rollDice] and checks if the answer is correct
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    //Calls [rollDice] and checks if the answer is correct
    private fun onEqualClick() {
        rollDice()

        if (lastThrow == currentThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    //Displays a correct Toast message
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    //Displays an incorrect Toast message
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }
}
