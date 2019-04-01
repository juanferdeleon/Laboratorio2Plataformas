package com.example.laboratorio2

/**
 * LapHistory Interface
 */
interface LapHistory {

    var lapHistory: ArrayList<Int> // Historial de vueltas

    fun clear() // Limpiar historial
    fun add(element: Int) // Agregar elemento
    fun del(elementIndex: Int) // Elimina elemento en la posición

}