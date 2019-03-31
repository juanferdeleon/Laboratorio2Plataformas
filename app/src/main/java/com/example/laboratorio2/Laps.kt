package com.example.laboratorio2

/**
 * Lap class
 * @author Juan Fernando De Leon Quezada
 */
class Laps: LapHistory {


    override val lapHistory: ArrayList<Int> = ArrayList()// Historial de vueltas

    override fun clear(){
        lapHistory.clear()
    }

    override fun add(element: Int) {
        lapHistory.add(element)
    }

    override fun del(elementIndex: Int) {
        lapHistory.removeAt(elementIndex)
    }

}