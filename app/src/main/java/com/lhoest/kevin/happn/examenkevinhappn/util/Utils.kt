package com.lhoest.kevin.happn.examenkevinhappn.util

import java.lang.Exception

object Utils {

    //inpired of .get() kotlin method and "try!" in swift language
    inline fun <T, R> T.tryOrNull(block: (T) -> R): R? {
        return try {
            block(this)
        } catch (e : Exception) {
            System.out.print(e.message)
            null
        }
    }
}