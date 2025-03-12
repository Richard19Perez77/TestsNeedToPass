package com.rperez.testsneedtopass.prac

import com.rperez.testsneedtopass.prac.Constants.Companion.intStringMap
import com.rperez.testsneedtopass.prac.Constants.Companion.names

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
    fun containsValue1(): Boolean {
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
        return names.findLast { it.contains("i") }
    }

    /**
     * Get first element in list or emtpy
     *
     * @return
     */
    fun getFirstElementInListOrEmtpy(): String {
        return if (names.isNotEmpty()) return names.first() else ""
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
    fun listMinusFirstAndLast(): List<String> {
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
}