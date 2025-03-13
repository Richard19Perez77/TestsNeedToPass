package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.beginner.CollectionsPrac
import com.rperez.testsneedtopass.constants.Constants
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CollectionsTests {

    var collectionsPrac = CollectionsPrac()

    @Test
    fun containsKey1Test() {
        var actual = collectionsPrac.containsKey1()
        assertTrue(actual)
    }

    @Test
    fun containsValue1test() {
        var actual = collectionsPrac.containsValueOne()
        assertTrue(actual)
    }

    @Test
    fun elementAt0ListTest() {
        var expected = "Richard"
        var actual = collectionsPrac.elementAt0List()
        assertTrue(actual == expected)
    }

    @Test
    fun findRichardFromCKTest() {
        var expected = "Rick"
        var actual = collectionsPrac.findRickFromPartial()
        assertTrue(actual == expected)
    }

    @Test
    fun findLastRickTest() {
        var expected = "Rick"
        var actual = collectionsPrac.findLastRick()
        assertTrue(actual == expected)
    }

    @Test
    fun getFirstElementInListOrEmtpyTest() {
        var expected = "Richard"
        var actual = collectionsPrac.getFirstElementInListOrEmpty()
        assertTrue(actual == expected)
    }

    @Test
    fun getFirstElementInListOrNullTest() {
        var expected = "Richard"
        var actual = collectionsPrac.getFirstElementInListOrNull()
        assertTrue(actual == expected)
    }

    @Test
    fun indexOfFirstRicTest() {
        var expected = 0
        var actual = collectionsPrac.indexOfFirstRic()
        assertTrue(actual == expected)
    }

    @Test
    fun indexOfLastRicTest() {
        var expected = 3
        var actual = collectionsPrac.indexOfLastRic()
        assertTrue(actual == expected)
    }

    @Test
    fun listMinusFirstAndLastTest() {
        var expected = listOf<String>("Ginger Ale", "7-Up")
        var actual = collectionsPrac.middleElementsOrAll()
        assertTrue(actual == expected)
    }

    @Test
    fun mapNameToCharCountTest() {
        var expected = mapOf<String, Int>(
            "Richard" to 7,
            "Ginger Ale" to 10,
            "7-Up" to 4,
            "Rick" to 4
        )
        var actual = collectionsPrac.mapNameToCharCount()
        assertTrue(actual == expected)
    }

    @Test
    fun mapNameInitialsTocountTest() {
        var expected = mapOf<Char, Int>(
            'R' to 2,
            'G' to 1,
            '7' to 1,
        )
        var actual = collectionsPrac.mapNameInitialsToCount()
        assertTrue(actual == expected)
    }

    @Test
    fun removeDuplicatesTest() {
        var expected = Constants.names
        var actual = collectionsPrac.removeDuplicates()
        assertTrue(actual == expected)
    }
}