package com.lhoest.kevin.happn.examenkevinhappn.util

object ListUtils {
    fun <T> getItemInTheMidle(collection: List<T>): T {
        val size : Int = collection.size
        return collection[size/2]
    }
}