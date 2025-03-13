package com.rperez.testsneedtopass.beginner

import com.rperez.testsneedtopass.constants.Constants.Companion.intStringMap
import com.rperez.testsneedtopass.constants.Constants.Companion.names
import com.rperez.testsneedtopass.constants.Constants.Companion.namesDuplicates
import com.rperez.testsneedtopass.constants.Constants.Companion.numbers
import kotlin.math.sqrt

/**
 * Solutions for each file to make each test pass
 *
 * @constructor Create empty Collections prac
 */
class CollectionsPrac {

    /**
     * Contains key1
     *
     * @return
     */
    fun containsKey1(): Boolean {
        return intStringMap.keys.contains(1)
    }

    /**
     * Contains value1
     *
     * @return
     */
    fun containsValueOne(): Boolean {
        return intStringMap.values.contains("one")
    }

    /**
     * Element at1list
     *
     * @return
     */
    fun elementAt0List(): String {
        return if (names.isNotEmpty()) {
            names.elementAt(0)
        } else ""
    }

    /**
     * Find rick from ck
     *
     * @return
     */
    fun findRickFromPartial(): String? {
        return names.find { it.contains("ck") }
    }

    /**
     * Find last rick
     *
     * @return
     */
    fun findLastRick(): String? {
        return names.findLast { it.contains("Rick") }
    }

    /**
     * Get first element in list or emtpy
     *
     * @return
     */
    fun getFirstElementInListOrEmpty(): String {
        return if (names.isNotEmpty()) names.first() else ""
    }

    /**
     * Get first element in list or null
     *
     * @return
     */
    fun getFirstElementInListOrNull(): String? {
        return names.firstOrNull()
    }

    /**
     * Index of first ric
     *
     * @return
     */
    fun indexOfFirstRic(): Int {
        return names.indexOfFirst { it.contains("Ric") }
    }

    /**
     * Index of last ric
     *
     * @return
     */
    fun indexOfLastRic(): Int {
        return names.indexOfLast { it.contains("Ric") }
    }

    /**
     * List minus first and last
     *
     * @return
     */
    fun middleElementsOrAll(): List<String> {
        return if (names.size >= 2) {
            names.slice(1 until names.size - 1)
        } else names
    }

    /**
     * Map name to char count
     *
     * @return
     */
    fun mapNameToCharCount(): Map<String, Int> {
        return names.associate { it to it.length }
    }

    /**
     * Map name initials to count
     *
     * @return
     */
    fun mapNameInitialsToCount(): Map<Char, Int> {
        return names.groupingBy { it.first() }.eachCount()
    }

    /**
     * Remove duplicates
     *
     * @return
     */
    fun removeDuplicates(): List<String> {
        return namesDuplicates.toSet().toList()
    }

    /**
     * Numbers list
     */
    var numbersList = listOf<Int>(1, 2, 3, 1, 5, 10, 1, 2)

    /**
     * Create map of list item to list of occurrences
     *
     * @return
     */
    fun createMapOfListItemToListOfOccurrences(): Map<Int, List<Int>> {
        return numbersList.groupBy { it }
    }

    /**
     * Map of value to count
     *
     * @return
     */
    fun mapOfValueToCount(): Map<Int, Int> {
        return numbersList.groupingBy { it }.eachCount()
    }

    /**
     * String name
     */
    var stringName = "Richard"

    /**
     * Map string to chars and count of each
     *
     * @return
     */
    fun mapStringToCharsAndCountOfEach(): Map<Char, Int> {
        // don't map to lowercase will turn to a string, lowercase first
        return stringName.lowercase().groupingBy { it }.eachCount()
    }

    /**
     * Remove1rick
     *
     * @return
     */
    fun remove1Rick(): List<String> {
        return names - "Rick"
    }

    /**
     * Remove all rick
     *
     * @return
     */
    fun removeAllRick(): List<String> {
        return names.filter { it != "Rick" }
    }

    /**
     * Remove rs
     *
     * @return
     */
    fun removeRs(): List<String> {
        return names.filterNot { it.lowercase().contains("r") }
    }

    /**
     * Make squares
     *
     * @return
     */
    fun makeSquares(): List<Int> {
        return numbers.map { it * it }
    }

    /**
     * Get square roots
     *
     * @return
     */
    fun getSquareRoots(): List<Int> {
        return numbers.map { sqrt(it.toDouble()).toInt() }
    }

    /**
     * Get string versions
     *
     * @return
     */
    fun getStringVersions(): List<String> {
        return numbers.map { it.toString() }
    }
}
