package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.beginner.CollectionsBeginner
import com.rperez.testsneedtopass.constants.Constants
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CollectionsTests {

    var collectionsPrac = CollectionsBeginner()

    @Test
    fun containsKey1Test() {
        var actual = collectionsPrac.containsKey1(Constants.intStringMap)
        assertTrue(actual)
    }

    @Test
    fun containsValue1test() {
        var actual = collectionsPrac.containsValueOne(Constants.intStringMap)
        assertTrue(actual)
    }

    @Test
    fun elementAt0ListTest() {
        var expected = "Richard"
        var actual = collectionsPrac.elementAt0List(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun findRichardFromCKTest() {
        var expected = "Rick"
        var actual = collectionsPrac.findRickFromPartial(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun findLastRickTest() {
        var expected = "Rick"
        var actual = collectionsPrac.findLastRick(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun getFirstElementInListOrEmtpyTest() {
        var expected = "Richard"
        var actual = collectionsPrac.getFirstElementInListOrEmpty(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun getFirstElementInListOrNullTest() {
        var expected = "Richard"
        var actual = collectionsPrac.getFirstElementInListOrNull(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun indexOfFirstRicTest() {
        var expected = 0
        var actual = collectionsPrac.indexOfFirstRic(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun indexOfLastRicTest() {
        var expected = 3
        var actual = collectionsPrac.indexOfLastRic(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun listMinusFirstAndLastTest() {
        var expected = listOf<String>("Ginger Ale", "7-Up")
        var actual = collectionsPrac.middleElementsOrAll(Constants.names)
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
        var actual = collectionsPrac.mapNameToCharCount(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun mapNameInitialsTocountTest() {
        var expected = mapOf<Char, Int>(
            'R' to 2,
            'G' to 1,
            '7' to 1,
        )
        var actual = collectionsPrac.mapNameInitialsToCount(Constants.names)
        assertTrue(actual == expected)
    }

    @Test
    fun removeDuplicatesTest() {
        var expected = Constants.names
        var actual = collectionsPrac.removeDuplicates(Constants.namesDuplicates)
        assertTrue(actual == expected)
    }
}