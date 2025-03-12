package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.prac.MapPrac
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.math.sqrt

class MapTests {

    var mapPrac = MapPrac()

    @Test
    fun makeSquaresTest() {
        var expected = listOf<Int>(1 * 1, 3 * 3, 55 * 55, 100 * 100, 34 * 34)
        var actual = mapPrac.makeSquares()
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun getSquareRootsTest() {
        var expected = listOf<Int>(
            sqrt(1.toDouble()).toInt(),
            sqrt(3.toDouble()).toInt(),
            sqrt(55.toDouble()).toInt(),
            sqrt(100.toDouble()).toInt(),
            sqrt(34.toDouble()).toInt()
        )
        var actual = mapPrac.getSquareRoots()
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun getStringVersionsTest() {
        var expected = listOf<String>("1", "3", "55", "100", "34")
        var actual = mapPrac.getStringVersions()
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }
}