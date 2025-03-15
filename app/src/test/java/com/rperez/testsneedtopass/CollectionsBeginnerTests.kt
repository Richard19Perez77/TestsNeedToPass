package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.beginner.CollectionsBeginner
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Collections beginner test
 *
 * @constructor Create empty Collections beginner test
 */
class CollectionsBeginnerTests {

    /**
     * Collections beginner
     */
    private val collectionsBeginner = CollectionsBeginner()

    /**
     * Test contains key1
     *
     */
    @Test
    fun testContainsKey1() {
        val map = mapOf(1 to "one", 2 to "two")
        assertTrue(collectionsBeginner.containsKey1(map))

        val emptyMap = emptyMap<Int, String>()
        assertFalse(collectionsBeginner.containsKey1(emptyMap))
    }

    /**
     * Test contains value one
     *
     */
    @Test
    fun testContainsValueOne() {
        val map = mapOf(1 to "one", 2 to "two")
        assertTrue(collectionsBeginner.containsValueOne(map))

        val mapWithoutOne = mapOf(1 to "uno", 2 to "dos")
        assertFalse(collectionsBeginner.containsValueOne(mapWithoutOne))
    }

    /**
     * Test element at0list
     *
     */
    @Test
    fun testElementAt0List() {
        val list = listOf("Rick", "Morty", "Summer")
        assertEquals("Rick", collectionsBeginner.elementAt0List(list))

        val emptyList = emptyList<String>()
        assertEquals("", collectionsBeginner.elementAt0List(emptyList))
    }

    /**
     * Test find rick from partial
     *
     */
    @Test
    fun testFindRickFromPartial() {
        val list = listOf("Rick", "Morty", "Summer")
        assertEquals("Rick", collectionsBeginner.findRickFromPartial(list))

        val listWithoutRick = listOf("Morty", "Summer")
        assertNull(collectionsBeginner.findRickFromPartial(listWithoutRick))
    }

    /**
     * Test find last rick
     *
     */
    @Test
    fun testFindLastRick() {
        val list = listOf("Rick", "Morty", "Rick", "Summer")
        assertEquals("Rick", collectionsBeginner.findLastRick(list))

        val listWithoutRick = listOf("Morty", "Summer")
        assertNull(collectionsBeginner.findLastRick(listWithoutRick))
    }

    /**
     * Test get first element in list or empty
     *
     */
    @Test
    fun testGetFirstElementInListOrEmpty() {
        val list = listOf("Rick", "Morty", "Summer")
        assertEquals("Rick", collectionsBeginner.getFirstElementInListOrEmpty(list))

        val emptyList = emptyList<String>()
        assertEquals("", collectionsBeginner.getFirstElementInListOrEmpty(emptyList))
    }

    /**
     * Test get first element in list or null
     *
     */
    @Test
    fun testGetFirstElementInListOrNull() {
        val list = listOf("Rick", "Morty", "Summer")
        assertEquals("Rick", collectionsBeginner.getFirstElementInListOrNull(list))

        val emptyList = emptyList<String>()
        assertNull(collectionsBeginner.getFirstElementInListOrNull(emptyList))
    }

    /**
     * Test index of first ric
     *
     */
    @Test
    fun testIndexOfFirstRic() {
        val list = listOf("Rick", "Morty", "Summer", "Eric")
        assertEquals(0, collectionsBeginner.indexOfFirstRic(list))

        val listWithoutRic = listOf("Morty", "Summer")
        assertEquals(-1, collectionsBeginner.indexOfFirstRic(listWithoutRic))
    }

    /**
     * Test index of last ric
     *
     */
    @Test
    fun testIndexOfLastRic() {
        val list = listOf("Rick", "Morty", "Summer", "Eric")
        assertEquals(3, collectionsBeginner.indexOfLastRic(list))

        val listWithoutRic = listOf("Morty", "Summer")
        assertEquals(-1, collectionsBeginner.indexOfLastRic(listWithoutRic))
    }

    /**
     * Test middle elements or all
     *
     */
    @Test
    fun testMiddleElementsOrAll() {
        val list = listOf("Rick", "Morty", "Summer", "Beth")
        assertEquals(listOf("Morty", "Summer"), collectionsBeginner.middleElementsOrAll(list))

        val smallList = listOf("Rick", "Morty")
        assertEquals(listOf("Rick", "Morty"), collectionsBeginner.middleElementsOrAll(smallList))
    }

    /**
     * Test map name to char count
     *
     */
    @Test
    fun testMapNameToCharCount() {
        val list = listOf("Rick", "Morty")
        val expectedMap = mapOf("Rick" to 4, "Morty" to 5)
        assertEquals(expectedMap, collectionsBeginner.mapNameToCharCount(list))
    }

    /**
     * Test map name initials to count
     *
     */
    @Test
    fun testMapNameInitialsToCount() {
        val list = listOf("Rick", "Morty", "Rick", "Summer")
        val expectedMap = mapOf('R' to 2, 'M' to 1, 'S' to 1)
        assertEquals(expectedMap, collectionsBeginner.mapNameInitialsToCount(list))
    }

    /**
     * Test remove duplicates
     *
     */
    @Test
    fun testRemoveDuplicates() {
        val list = listOf("Rick", "Morty", "Rick", "Summer")
        val expectedList = listOf("Rick", "Morty", "Summer")
        assertEquals(expectedList, collectionsBeginner.removeDuplicates(list))
    }

    /**
     * Test create map of list item to list of occurrences
     *
     */
    @Test
    fun testCreateMapOfListItemToListOfOccurrences() {
        val list = listOf(1, 2, 2, 3, 3, 3)
        val expectedMap = mapOf(
            1 to listOf(1),
            2 to listOf(2, 2),
            3 to listOf(3, 3, 3)
        )
        assertEquals(expectedMap, collectionsBeginner.createMapOfListItemToListOfOccurrences(list))
    }

    /**
     * Test map of value to count
     *
     */
    @Test
    fun testMapOfValueToCount() {
        val list = listOf(1, 2, 2, 3, 3, 3)
        val expectedMap = mapOf(1 to 1, 2 to 2, 3 to 3)
        assertEquals(expectedMap, collectionsBeginner.mapOfValueToCount(list))
    }

    /**
     * Test map string to chars and count of each
     *
     */
    @Test
    fun testMapStringToCharsAndCountOfEach() {
        val string = "hello"
        val expectedMap = mapOf('h' to 1, 'e' to 1, 'l' to 2, 'o' to 1)
        assertEquals(expectedMap, collectionsBeginner.mapStringToCharsAndCountOfEach(string))
    }

    /**
     * Test remove1rick
     *
     */
    @Test
    fun testRemove1Rick() {
        val list = listOf("Rick", "Morty", "Rick", "Summer")
        val expectedList = listOf("Morty", "Rick", "Summer")
        assertEquals(expectedList, collectionsBeginner.remove1Rick(list))
    }

    /**
     * Test remove all rick
     *
     */
    @Test
    fun testRemoveAllRick() {
        val list = listOf("Rick", "Morty", "Rick", "Summer")
        val expectedList = listOf("Morty", "Summer")
        assertEquals(expectedList, collectionsBeginner.removeAllRick(list))
    }

    /**
     * Test remove rs
     *
     */
    @Test
    fun testRemoveRs() {
        val list = listOf("Rick", "Morty", "Summer", "Beth", "Jerry", "Photography Raptor")
        val expectedList = listOf("Beth")
        assertEquals(expectedList, collectionsBeginner.removeRs(list))
    }

    /**
     * Test make squares
     *
     */
    @Test
    fun testMakeSquares() {
        val list = listOf(1, 2, 3)
        val expectedList = listOf(1, 4, 9)
        assertEquals(expectedList, collectionsBeginner.makeSquares(list))
    }

    /**
     * Test get square roots
     *
     */
    @Test
    fun testGetSquareRoots() {
        val list = listOf(4, 9, 16)
        val expectedList = listOf(2, 3, 4)
        assertEquals(expectedList, collectionsBeginner.getSquareRoots(list))
    }

    /**
     * Test get string versions
     *
     */
    @Test
    fun testGetStringVersions() {
        val list = listOf(1, 2, 3)
        val expectedList = listOf("1", "2", "3")
        assertEquals(expectedList, collectionsBeginner.getStringVersions(list))
    }
}