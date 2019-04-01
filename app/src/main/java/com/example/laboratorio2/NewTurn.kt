package com.example.laboratorio2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.collections.ArrayList

/**
 * Activity 2
 * @author Juan Fernando De Leon Quezada
 */
class NewTurn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_turn)

        val recLaps: ArrayList<Int> = ArrayList()

        recLaps.add(1)
        recLaps.add(5)
        recLaps.add(10)
        recLaps.add(15)

        val laps = intent.getSerializableExtra("lapHistory") as ArrayList<Int>

        val listViewHistory = findViewById<ListView>(R.id.recomended)

        listViewHistory.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, recLaps)

        //Substract Lap button
        val subLap = findViewById<Button>(R.id.sub)

        //Substract Lap Counter
        subLap.setOnClickListener {

            //Gets text from textview
            var textView: TextView = findViewById<TextView>(R.id.amount) as TextView
            var amount: String = textView.text.toString()
            //Substract 1 to the text
            var newAmount: Int = amount.toInt()
            if (newAmount == 0){
                //Sets new Text
                var newText = findViewById<TextView>(R.id.amount).apply {
                    text = newAmount.toString()
                }
            } else {
                newAmount -= 1
                var newText = findViewById<TextView>(R.id.amount).apply {
                    text = newAmount.toString()
                }
            }

        }

        //AddLap Button
        val addLap = findViewById<Button>(R.id.add)

        //Add lap to counter
        addLap.setOnClickListener{

            //Gets text from textview
            var textView: TextView = findViewById<TextView>(R.id.amount) as TextView
            var amount: String = textView.text.toString()
            //Adds 1 to the text
            var newAmount: Int = amount.toInt()
            newAmount += 1
            //Sets new Text
            var newText = findViewById<TextView>(R.id.amount).apply {
                text = newAmount.toString()
            }

        }

        //Add to history
        val addHistory = findViewById<Button>(R.id.addHistory)

        addHistory.setOnClickListener{

            //Gets text from textview
            var textView: TextView = findViewById<TextView>(R.id.amount) as TextView
            var amount: String = textView.text.toString()
            //Adds the current amount to Array
            var newAmount: Int = amount.toInt()

            if (newAmount == 0){
                Toast.makeText(this, "No es posible agregar 0 vueltas", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Se ha agregado con exito.", Toast.LENGTH_SHORT).show()

                laps.add(newAmount)

                val intent = Intent(this, MainActivity::class.java).putExtra("newLapHistory", laps)
                startActivity(intent)
            }

        }

        //Main Menu Button
        val mainMenu = findViewById<Button>(R.id.mainMenu)

        mainMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).putExtra("newLapHistory", laps)
            startActivity(intent)
        }

        //Sets the lap counter to one on the listview
        listViewHistory.setOnItemClickListener { parent, view, position, id ->
            var newText = findViewById<TextView>(R.id.amount).apply {
                text = laps.get(position).toString()
            }
        }

    }
}
