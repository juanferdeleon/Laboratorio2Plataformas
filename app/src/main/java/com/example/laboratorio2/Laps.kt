package com.example.laboratorio2

/**
 * Lap class
 * @author Juan Fernando De Leon Quezada
 */
class Laps: LapHistory{

    override var lapHistory = ArrayList<Int>()

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