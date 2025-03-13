package com.rperez.testsneedtopass.advanced

import com.rperez.testsneedtopass.constants.Constants.Companion.stores
import com.rperez.testsneedtopass.constants.Constants.Companion.Item
import com.rperez.testsneedtopass.constants.Constants.Companion.Store
import com.rperez.testsneedtopass.constants.Constants.Companion.items
import com.rperez.testsneedtopass.constants.Constants.Companion.words
import com.rperez.testsneedtopass.constants.Constants.Companion.people
import com.rperez.testsneedtopass.constants.Constants.Companion.Person
import com.rperez.testsneedtopass.constants.Constants.Companion.numbersOccurrences
import com.rperez.testsneedtopass.constants.Constants.Companion.employees
import com.rperez.testsneedtopass.constants.Constants.Companion.namesMap
import com.rperez.testsneedtopass.constants.Constants.Companion.nestedList
import com.rperez.testsneedtopass.constants.Constants.Companion.numbersListOddEven
import com.rperez.testsneedtopass.constants.Constants.Companion.numbersMap
import com.rperez.testsneedtopass.constants.Constants.Companion.rawData
import com.rperez.testsneedtopass.constants.Constants.Companion.salaries
import com.rperez.testsneedtopass.constants.Constants.Companion.sentence

/**
 * Collections advanced
 *
 * @constructor Create empty Collections advanced
 */
class CollectionsAdvanced {

    /**
     * Group people by age
     *
     * @return
     */
    fun groupPeopleByAge(): Map<Int, List<Person>> {
        return people.groupBy { it.age }
    }

    /**
     * Count occurrences of each word
     *
     * @return
     */
    fun countOccurrencesOfEachWord(): Map<String, Int> {
        return words.groupingBy { it }.eachCount()
    }

    /**
     * Map value to accumulation of occurrence
     *
     * @return
     */
    fun mapValueToAccumulationOfOccurrence(): Map<Int, Int> {
        return numbersOccurrences.groupingBy { it }.fold(0) { acc, _ -> acc + 1 }
    }

    /**
     * Group by employees age then group by length of name
     *
     * @return
     */
    fun groupByEmployeesAgeThenGroupByLengthOfName(): Map<Int, Map<Int, List<Person>>> {
        return employees.groupBy { it.age }
            .mapValues { (_, people) -> people.groupBy { it.name.length } }
    }

    /**
     * Convert map values to uppercase
     *
     * @return
     */
    fun convertMapValuesToUppercase(): Map<Int, String> {
        return namesMap.mapValues { (_, value) -> value.uppercase() }
    }


    /**
     * Increase salaries by10percent
     *
     * @return
     */
    fun increaseSalariesBy10Percent(): Map<String, Int> {
        return salaries.mapValues { (_, salary) -> (salary * 1.1).toInt() }
    }


    /**
     * Group employees by age and count by name
     *
     * @return
     */
    fun groupEmployeesByAgeAndCountByName(): Map<Int, Int> {
        return employees.groupBy { it.age }
            .mapValues { (_, people) -> people.size }
    }


    /**
     * Convert int key to string
     *
     * @return
     */
    fun convertIntKeyToString(): Map<String, String> {
        return numbersMap.mapKeys { (key, _) -> "Number-$key" }
    }

    /**
     * Sum the lists of List of ints
     *
     * @return
     */
    fun sumTheListsOfListOfInts(): Int {
        return nestedList.flatten().sum()
    }

    /**
     * String parsing into list then map
     *
     *  @return
     */
    fun stringParsingIntoListThenMap(): Map<String, Int> {
        return rawData.split(",") // split into list of items
            .map { it.split(":") } // split into pairs for k:v
            .associate { it[0] to it[1].toInt() } // create map entry
    }

    /**
     * Group words by length from a sentence
     *
     * @return
     */
    fun groupWordsByLengthFromASentence(): Map<Int, List<String>> {
        return sentence.split(" ").groupBy { it.length }
    }

    /**
     * Calculate word frequency in a sentence
     *
     * @return
     */
    fun calculateWordFrequencyInASentence(): Map<String, Int> {
        return sentence.split(" ").groupingBy { it }.eachCount()
    }


    /**
     * Filter and sum based on even count
     *
     * @return
     */
    fun filterAndSumBasedOnEvenCount(): Int {
        return numbersListOddEven.filter { it % 2 == 0 }.sum()
    }

    /**
     * Get pair of lists splitting available and unavailable items
     *
     * @return
     */
    fun getPairOfListsSplittingAvailableAndUnavailableItems(): Pair<List<Item>, List<Item>> {
        return stores.flatMap { it.items }.partition { it.isAvailable }
    }

    /**
     * Get stores with more items available than not
     *
     * @return
     */
    fun getStoresWithMoreItemsAvailableThanNot(): Set<Store> {
        return stores.filter { store ->
            store.items.count { it.isAvailable } > store.items.count { !it.isAvailable }
        }.toSet()
    }

    fun separateItemsByAvailableFlagIntoLists(): Pair<List<Item>, List<Item>> {
        return items.partition { it.isAvailable }
    }

    /**
     * Get items available in all stores
     *
     * @return
     */
    fun getItemsAvailableInAllStores(): Set<Item> {
        return stores.map { it.items.toSet() }
            .reduce { available, items ->
                available.intersect(items)
            }
    }

    /**
     * Map items to stores as available count
     *
     * @return
     */
    fun mapItemsToStoresAsAvailableCount(): Map<Item, Int> {
        return stores.flatMap { store ->
            store.items.filter { it.isAvailable }
        }.groupingBy { it }
            .eachCount()
    }

    /**
     * Find the most available item in stores
     *
     * @return
     */
    fun findTheMostAvailableItemsInStores(): List<Item> {
        val itemCounts = stores.flatMap { it.items.filter { it.isAvailable } }
            .groupingBy { it }
            .eachCount()

        val maxCount = itemCounts.values.maxOrNull() ?: return emptyList()

        return itemCounts.filterValues { it == maxCount }.keys.toList()
    }

    /**
     * Find the store with the most available items
     *
     * @return
     */
    fun findTheStoreWithTheMostAvailableItems(): List<Store> {
        // for each store count how many available items there are
        // return store with max count
        var res = mutableListOf<Store>()
        var maxCount = 0
        for (s in stores) {
            var availableCount = 0
            for (i in s.items) {
                if (i.isAvailable) {
                    // increase local count
                    availableCount++
                }
            }
            // if local count > max, use this store as return value
            if (availableCount > maxCount) {
                res.clear()
                res.add(s)
            } else if (availableCount == maxCount) {
                res.add(s)
            }
        }
        return res
    }

    /**
     * Find the store with the most available items2
     *
     * @return
     */
    fun findTheStoreWithTheMostAvailableItems2(): List<Store> {
        val maxCount =
            stores.maxOfOrNull { it.items.count { it.isAvailable } } ?: return emptyList()
        return stores.filter { it.items.count { it.isAvailable } == maxCount }
    }
}