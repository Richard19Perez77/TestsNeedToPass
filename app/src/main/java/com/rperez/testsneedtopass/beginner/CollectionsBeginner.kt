package com.rperez.testsneedtopass.beginner

import kotlin.math.sqrt

/**
 * Collections beginner
 *
 * @constructor Create empty Collections beginner
 */
class CollectionsBeginner {

    /**
     * Contains key1
     *
     * @param intStringMap
     * @return
     */
    fun containsKey1(intStringMap: Map<Int, String>): Boolean {
        return intStringMap.keys.contains(1)
    }

    /**
     * Contains value one
     *
     * @param intStringMap
     * @return
     */
    fun containsValueOne(intStringMap: Map<Int, String>): Boolean {
        return intStringMap.values.contains("one")
    }

    /**
     * Element at0list
     *
     * @param names
     * @return
     */
    fun elementAt0List(names: List<String>): String {
        return if (names.isNotEmpty()) {
            names.elementAt(0)
        } else ""
    }

    /**
     * Find rick from partial
     *
     * @param names
     * @return
     */
    fun findRickFromPartial(names: List<String>): String? {
        return names.find { it.contains("ck") }
    }

    /**
     * Find last rick
     *
     * @param names
     * @return
     */
    fun findLastRick(names: List<String>): String? {
        return names.findLast { it.contains("Rick") }
    }

    /**
     * Get first element in list or empty
     *
     * @param names
     * @return
     */
    fun getFirstElementInListOrEmpty(names: List<String>): String {
        return if (names.isNotEmpty()) names.first() else ""
    }

    /**
     * Get first element in list or null
     *
     * @param names
     * @return
     */
    fun getFirstElementInListOrNull(names: List<String>): String? {
        return names.firstOrNull()
    }

    /**
     * Index of first ric
     *
     * @param names
     * @return
     */
    fun indexOfFirstRic(names: List<String>): Int {
        return names.indexOfFirst { it.contains("Ric") }
    }

    /**
     * Index of last ric
     *
     * @param names
     * @return
     */
    fun indexOfLastRic(names: List<String>): Int {
        return names.indexOfLast { it.lowercase().contains("ric") }
    }

    /**
     * Middle elements or all
     *
     * @param names
     * @return
     */
    fun middleElementsOrAll(names: List<String>): List<String> {
        return if (names.size > 2) {
            names.slice(1 until names.size - 1)
        } else names
    }

    /**
     * Map name to char count
     *
     * @param names
     * @return
     */
    fun mapNameToCharCount(names: List<String>): Map<String, Int> {
        return names.associate { it to it.length }
    }

    /**
     * Map name initials to count
     *
     * @param names
     * @return
     */
    fun mapNameInitialsToCount(names: List<String>): Map<Char, Int> {
        return names.groupingBy { it.first() }.eachCount()
    }

    /**
     * Remove duplicates
     *
     * @param namesDuplicates
     * @return
     */
    fun removeDuplicates(namesDuplicates: List<String>): List<String> {
        return namesDuplicates.toSet().toList()
    }

    /**
     * Create map of list item to list of occurrences
     *
     * @param numbersList
     * @return
     */
    fun createMapOfListItemToListOfOccurrences(numbersList: List<Int>): Map<Int, List<Int>> {
        return numbersList.groupBy { it }
    }

    /**
     * Map of value to count
     *
     * @param numbersList
     * @return
     */
    fun mapOfValueToCount(numbersList: List<Int>): Map<Int, Int> {
        return numbersList.groupingBy { it }.eachCount()
    }


    /**
     * Map string to chars and count of each
     *
     * @param stringName
     * @return
     */
    fun mapStringToCharsAndCountOfEach(stringName: String): Map<Char, Int> {
        // don't map to lowercase will turn to a string, lowercase first
        return stringName.lowercase().groupingBy { it }.eachCount()
    }

    /**
     * Remove1rick
     *
     * @param names
     * @return
     */
    fun remove1Rick(names: List<String>): List<String> {
        return names - "Rick"
    }

    /**
     * Remove all rick
     *
     * @param names
     * @return
     */
    fun removeAllRick(names: List<String>): List<String> {
        return names.filter { it != "Rick" }
    }

    /**
     * Remove rs
     *
     * @param names
     * @return
     */
    fun removeRs(names: List<String>): List<String> {
        return names.filterNot { it.lowercase().contains("r") }
    }

    /**
     * Make squares
     *
     * @param numbers
     * @return
     */
    fun makeSquares(numbers: List<Int>): List<Int> {
        return numbers.map { it * it }
    }

    /**
     * Get square roots
     *
     * @param numbers
     * @return
     */
    fun getSquareRoots(numbers: List<Int>): List<Int> {
        return numbers.map { sqrt(it.toDouble()).toInt() }
    }

    /**
     * Get string versions
     *
     * @param numbers
     * @return
     */
    fun getStringVersions(numbers: List<Int>): List<String> {
        return numbers.map { it.toString() }
    }
}
