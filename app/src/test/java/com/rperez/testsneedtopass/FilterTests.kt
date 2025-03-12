package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.prac.FilterPrac
import com.rperez.testsneedtopass.prac.Constants
import org.junit.Test

import org.junit.Assert.*

class FilterTests {

    var filterPrac = FilterPrac()

    @Test
    fun remove1RickTest() {
        var expected = Constants.names - "Rick"
        var actual = filterPrac.remove1Rick()
        assertTrue(actual.containsAll(expected) && actual.size == expected.size)
        assertEquals(expected, actual)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun removeAllRickTest() {
        var expected = Constants.names.filter { it != "Rick" }
        var actual = filterPrac.removeAllRick()
        assertTrue(actual.containsAll(expected) && actual.size == expected.size)
        assertEquals(expected, actual)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun removeRsTest() {
        var expected = listOf<String>("7-Up")
        var actual = filterPrac.removeRs()
        assertTrue(actual.containsAll(expected) && actual.size == expected.size)
        assertEquals(expected, actual)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }
}