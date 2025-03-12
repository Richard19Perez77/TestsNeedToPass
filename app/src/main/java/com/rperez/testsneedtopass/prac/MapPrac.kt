package com.rperez.testsneedtopass.prac

import com.rperez.testsneedtopass.prac.Constants.Companion.numbers
import kotlin.math.sqrt

class MapPrac {

    fun makeSquares(): List<Int> {
        return numbers.map { it * it }
    }

    fun getSquareRoots(): List<Int> {
        return numbers.map { sqrt(it.toDouble()).toInt() }
    }

    fun getStringVersions(): List<String> {
        return numbers.map { it.toString() }
    }
}