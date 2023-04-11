package com.example.tennistracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.LayoutInflater
//import com.example.tennistracker.databinding.NewMatchBinding


var totalpoints = 0
var P1totalpoints = 0
var P2totalpoints = 0
var P1index = 0
var P2index = 0

//initalize array of possible game scores
val gameScores: IntArray = intArrayOf(0, 15, 30, 40)

class NewMatch : AppCompatActivity() {
    //private lateinit var binding: NewMatchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)
        //binding = NewMatchBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        val scoreP1 = findViewById<TextView>(R.id.scoreP1)
        val scoreP2 = findViewById<TextView>(R.id.scoreP2)
        //initalize player index to 1 to combat onCreate already starting game score at 0
        P1index = 1
        P2index = 1


        val P1Score = findViewById<Button>(R.id.btnP1Score)
        P1Score.setOnClickListener {
            totalpoints += 1
            P1totalpoints += 1
            if (P1index == 4) {
                P1index = 0
                P2index = 0
                scoreP2.text = gameScores[P2index].toString()
                P2index +=1

            }
            scoreP1.text = gameScores[P1index].toString()
            P1index+=1

        }
        val P2Score = findViewById<Button>(R.id.btnP2Score)
        P2Score.setOnClickListener {
            totalpoints += 1
            P2totalpoints += 1
            if (P2index == 4){
                P2index = 0
                P1index = 0
                scoreP1.text = gameScores[P1index].toString()
                P1index +=1
            }
            scoreP2.text = gameScores[P2index].toString()
            P2index+=1
        }




    }
}