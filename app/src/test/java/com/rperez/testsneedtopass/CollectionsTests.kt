package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.beginner.CollectionsBeginner
import com.rperez.testsneedtopass.constants.Constants
import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * Collections tests
 *
 * @constructor Create empty Collections tests
 */
class CollectionsTests {

    var collectionsPrac = CollectionsBeginner()

    /**
     * Contains key1test
     *
     */
    @Test
    fun containsKey1Test() {
        var actual = collectionsPrac.containsKey1(Constants.intStringMap)
        assertTrue(actual)
    }

    /**
     * Contains value1test
     *
     */
    @Test
    fun containsValue1test() {
        var actual = collectionsPrac.containsValueOne(Constants.intStringMap)
        assertTrue(actual)
    }

    /**
     * Element at0list test
     *
     */
    @Test
    fun elementAt0ListTest() {
        var expected = "Richard"
        var actual = collectionsPrac.elementAt0List(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Find richard from c k test
     *
     */
    @Test
    fun findRichardFromCKTest() {
        var expected = "Rick"
        var actual = collectionsPrac.findRickFromPartial(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Find last rick test
     *
     */
    @Test
    fun findLastRickTest() {
        var expected = "Rick"
        var actual = collectionsPrac.findLastRick(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Get first element in list or emtpy test
     *
     */
    @Test
    fun getFirstElementInListOrEmtpyTest() {
        var expected = "Richard"
        var actual = collectionsPrac.getFirstElementInListOrEmpty(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Get first element in list or null test
     *
     */
    @Test
    fun getFirstElementInListOrNullTest() {
        var expected = "Richard"
        var actual = collectionsPrac.getFirstElementInListOrNull(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Index of first ric test
     *
     */
    @Test
    fun indexOfFirstRicTest() {
        var expected = 0
        var actual = collectionsPrac.indexOfFirstRic(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Index of last ric test
     *
     */
    @Test
    fun indexOfLastRicTest() {
        var expected = 3
        var actual = collectionsPrac.indexOfLastRic(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * List minus first and last test
     *
     */
    @Test
    fun listMinusFirstAndLastTest() {
        var expected = listOf<String>("Ginger Ale", "7-Up")
        var actual = collectionsPrac.middleElementsOrAll(Constants.names)
        assertTrue(actual == expected)
    }

    /**
     * Map name to char count test
     *
     */
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

    /**
     * Map name initials tocount test
     *
     */
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

    /**
     * Remove duplicates test
     *
     */
    @Test
    fun removeDuplicatesTest() {
        var expected = Constants.names
        var actual = collectionsPrac.removeDuplicates(Constants.namesDuplicates)
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual)) // presence of elements matters, order doesn't
        fun List<String>.countMap(): Map<String, Int> = groupingBy { it }.eachCount()
        assertTrue(actual.countMap() == expected.countMap()) // duplicates and count matters, order doesn't
    }
}