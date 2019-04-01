package com.example.laboratorio2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

/**
 * Main Activity
 * @author Juan Fernando De Leon Quezada
 */
class MainActivity : AppCompatActivity() {

    var lapHistory: LapHistory = Laps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lapHistory.add(1)
        lapHistory.add(5)
        lapHistory.add(10)
        lapHistory.add(15)

        val listViewHistory = findViewById<ListView>(R.id.history)

        listViewHistory.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, lapHistory.lapHistory)

        //New lap button
        val newLap = findViewById<Button>(R.id.newlap)

        newLap.setOnClickListener {
            val intent = Intent(this, NewTurn::class.java).putExtra("lapHistory", lapHistory.lapHistory)
            startActivity(intent)
        }

        //Clear history button
        val clearHistory = findViewById<Button>(R.id.deleteH)

        //Delete all items from listView
        clearHistory.setOnClickListener{
            lapHistory.clear()
            Toast.makeText(this, "Se elimino el historial", Toast.LENGTH_SHORT).show()
            listViewHistory.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, lapHistory.lapHistory)
        }

        //Delet specific item OnClick from listview
        listViewHistory.setOnItemClickListener { parent, view, position, id ->
            var i = 0
            while (i < lapHistory.lapHistory.size){
                if (position == i){
                    Toast.makeText(this, "Se elimino el elemento no. $i", Toast.LENGTH_SHORT).show()
                    lapHistory.del(i)
                    listViewHistory.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, lapHistory.lapHistory)
                    break
                } else i++
            }
        }

    }
}
