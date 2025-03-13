package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.beginner.CollectionsPrac
import com.rperez.testsneedtopass.constants.Constants
import org.junit.Test

import org.junit.Assert.*

class FilterTests {

    var collectionsPrac = CollectionsPrac()

    @Test
    fun remove1RickTest() {
        var expected = Constants.names - "Rick"
        var actual = collectionsPrac.remove1Rick()
        assertTrue(actual.containsAll(expected) && actual.size == expected.size)
        assertEquals(expected, actual)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun removeAllRickTest() {
        var expected = Constants.names.filter { it != "Rick" }
        var actual = collectionsPrac.removeAllRick()
        assertTrue(actual.containsAll(expected) && actual.size == expected.size)
        assertEquals(expected, actual)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun removeRsTest() {
        var expected = listOf<String>("7-Up")
        var actual = collectionsPrac.removeRs()
        assertTrue(actual.containsAll(expected) && actual.size == expected.size)
        assertEquals(expected, actual)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }
}