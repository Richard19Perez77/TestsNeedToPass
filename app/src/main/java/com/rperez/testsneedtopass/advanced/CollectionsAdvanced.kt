package com.rperez.testsneedtopass.advanced

import com.rperez.testsneedtopass.constants.Constants.Companion.Item
import com.rperez.testsneedtopass.constants.Constants.Companion.Person
import com.rperez.testsneedtopass.constants.Constants.Companion.Store

/**
 * Collections advanced
 *
 * @constructor Create empty Collections advanced
 */
class CollectionsAdvanced {

    /**
     * Group people by age
     *
     * @param people
     * @return
     */
    fun groupPeopleByAge(people: List<Person>): Map<Int, List<Person>> {
        TODO()
    }

    /**
     * Count occurrences of each word
     *
     * @param words
     * @return
     */
    fun countOccurrencesOfEachWord(words: List<String>): Map<String, Int> {
        TODO()
    }

    /**
     * Map value to accumulation of occurrence
     *
     * @param numbersOccurrences
     * @return
     */
    fun mapValueToAccumulationOfOccurrence(numbersOccurrences: List<Int>): Map<Int, Int> {
        TODO()
    }

    /**
     * Group by employees age then group by length of name
     *
     * @param employees
     * @return
     */
    fun groupByEmployeesAgeThenGroupByLengthOfName(employees: List<Person>): Map<Int, Map<Int, List<Person>>> {
        TODO()
    }


    /**
     * Convert map values to uppercase
     *
     * @param namesMap
     * @return
     */
    fun convertMapValuesToUppercase(namesMap: Map<Int, String>): Map<Int, String> {
        TODO()
    }


    /**
     * Increase salaries by10percent
     *
     * @param salaries
     * @return
     */
    fun increaseSalariesBy10Percent(salaries: Map<String, Int>): Map<String, Int> {
        TODO()
    }


    /**
     * Group employees by age and count by name
     *
     * @param employees
     * @return
     */
    fun groupEmployeesByAgeAndCountByName(employees: List<Person>): Map<Int, Int> {
        TODO()
    }

    /**
     * Convert int key to string
     *
     * @param numbersMap
     * @return
     */
    fun convertIntKeyToString(numbersMap: Map<Int, String>): Map<String, String> {
        TODO()
    }

    /**
     * Sum the lists of list of ints
     *
     * @param nestedList
     * @return
     */
    fun sumTheListsOfListOfInts(nestedList: List<List<Int>>): Int {
        TODO()
    }

    /**
     * String parsing into list then map
     *
     * @param rawData
     * @return
     */
    fun stringParsingIntoListThenMap(rawData: String): Map<String, Int> {
        TODO() // create map entry
    }

    /**
     * Group words by length from a sentence
     *
     * @param sentence
     * @return
     */
    fun groupWordsByLengthFromASentence(sentence: String): Map<Int, List<String>> {
        TODO()
    }

    /**
     * Calculate word frequency in a sentence
     *
     * @param sentence
     * @return
     */
    fun calculateWordFrequencyInASentence(sentence: String): Map<String, Int> {
        TODO()
    }


    /**
     * Filter and sum based on even count
     *
     * @param numbersListOddEven
     * @return
     */
    fun filterAndSumBasedOnEvenCount(numbersListOddEven: List<Int>): Int {
        TODO()
    }

    /**
     * Get pair of lists splitting available and unavailable items
     *
     * @param stores
     * @return
     */
    fun getPairOfListsSplittingAvailableAndUnavailableItems(stores: List<Store>): Pair<List<Item>, List<Item>> {
        TODO()
    }

    /**
     * Get stores with more items available than not
     *
     * @param stores
     * @return
     */
    fun getStoresWithMoreItemsAvailableThanNot(stores: List<Store>): Set<Store> {
        TODO()
    }

    /**
     * Separate items by available flag into lists
     *
     * @param items
     * @return
     */
    fun separateItemsByAvailableFlagIntoLists(items: List<Item>): Pair<List<Item>, List<Item>> {
        TODO()
    }

    /**
     * Get items available in all stores
     *
     * @param stores
     * @return
     */
    fun getItemsAvailableInAllStores(stores: List<Store>): Set<Item> {
        TODO()
    }

    /**
     * Map items to stores as available count
     *
     * @param stores
     * @return
     */
    fun mapItemsToStoresAsAvailableCount(stores: List<Store>): Map<Item, Int> {
        TODO()
    }

    /**
     * Find the most available items in stores
     *
     * @param stores
     * @return
     */
    fun findTheMostAvailableItemsInStores(stores: List<Store>): List<Item> {
        TODO()
    }

    /**
     * Find the store with the most available items
     *
     * @param stores
     * @return
     */
    fun findTheStoreWithTheMostAvailableItems(stores: List<Store>): List<Store> {
        TODO()
    }

    /**
     * Find the store with the most available items2
     *
     * @param stores
     * @return
     */
    fun findTheStoreWithTheMostAvailableItems2(stores: List<Store>): List<Store> {
        TODO()
    }
}