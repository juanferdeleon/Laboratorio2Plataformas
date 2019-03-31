package com.example.laboratorio2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lapHistory: LapHistory



        val newLap = findViewById<Button>(R.id.newlap)

        newLap.setOnClickListener {
            val intent = Intent(this, NewTurn::class.java)
            startActivity(intent)
        }

    }
}
