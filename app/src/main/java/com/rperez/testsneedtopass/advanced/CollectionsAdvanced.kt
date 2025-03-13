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
        return people.groupBy { it.age }
    }

    /**
     * Count occurrences of each word
     *
     * @param words
     * @return
     */
    fun countOccurrencesOfEachWord(words: List<String>): Map<String, Int> {
        return words.groupingBy { it }.eachCount()
    }

    /**
     * Map value to accumulation of occurrence
     *
     * @param numbersOccurrences
     * @return
     */
    fun mapValueToAccumulationOfOccurrence(numbersOccurrences: List<Int>): Map<Int, Int> {
        return numbersOccurrences.groupingBy { it }.fold(0) { acc, _ -> acc + 1 }
    }

    /**
     * Group by employees age then group by length of name
     *
     * @param employees
     * @return
     */
    fun groupByEmployeesAgeThenGroupByLengthOfName(employees: List<Person>): Map<Int, Map<Int, List<Person>>> {
        return employees.groupBy { it.age }
            .mapValues { (_, people) -> people.groupBy { it.name.length } }
    }

    /**
     * Convert map values to uppercase
     *
     * @param namesMap
     * @return
     */
    fun convertMapValuesToUppercase(namesMap: Map<Int, String>): Map<Int, String> {
        return namesMap.mapValues { (_, value) -> value.uppercase() }
    }


    /**
     * Increase salaries by10percent
     *
     * @param salaries
     * @return
     */
    fun increaseSalariesBy10Percent(salaries: Map<String, Int>): Map<String, Int> {
        return salaries.mapValues { (_, salary) -> (salary * 1.1).toInt() }
    }


    /**
     * Group employees by age and count by name
     *
     * @param employees
     * @return
     */
    fun groupEmployeesByAgeAndCountByName(employees: List<Person>): Map<Int, Int> {
        return employees.groupBy { it.age }.mapValues { (_, people) -> people.size }
    }


    /**
     * Convert int key to string
     *
     * @param numbersMap
     * @return
     */
    fun convertIntKeyToString(numbersMap: Map<Int, String>): Map<String, String> {
        return numbersMap.mapKeys { (key, _) -> "Number-$key" }
    }

    /**
     * Sum the lists of list of ints
     *
     * @param nestedList
     * @return
     */
    fun sumTheListsOfListOfInts(nestedList: List<List<Int>>): Int {
        return nestedList.flatten().sum()
    }

    /**
     * String parsing into list then map
     *
     * @param rawData
     * @return
     */
    fun stringParsingIntoListThenMap(rawData: String): Map<String, Int> {
        return rawData.split(",") // split into list of items
            .map { it.split(":") } // split into pairs for k:v
            .associate { it[0] to it[1].toInt() } // create map entry
    }

    /**
     * Group words by length from a sentence
     *
     * @param sentence
     * @return
     */
    fun groupWordsByLengthFromASentence(sentence: String): Map<Int, List<String>> {
        return sentence.split(" ").groupBy { it.length }
    }

    /**
     * Calculate word frequency in a sentence
     *
     * @param sentence
     * @return
     */
    fun calculateWordFrequencyInASentence(sentence: String): Map<String, Int> {
        return sentence.split(" ").groupingBy { it }.eachCount()
    }


    /**
     * Filter and sum based on even count
     *
     * @param numbersListOddEven
     * @return
     */
    fun filterAndSumBasedOnEvenCount(numbersListOddEven: List<Int>): Int {
        return numbersListOddEven.filter { it % 2 == 0 }.sum()
    }

    /**
     * Get pair of lists splitting available and unavailable items
     *
     * @param stores
     * @return
     */
    fun getPairOfListsSplittingAvailableAndUnavailableItems(stores: List<Store>): Pair<List<Item>, List<Item>> {
        return stores.flatMap { it.items }.partition { it.isAvailable }
    }

    /**
     * Get stores with more items available than not
     *
     * @param stores
     * @return
     */
    fun getStoresWithMoreItemsAvailableThanNot(stores: List<Store>): Set<Store> {
        return stores.filter { store ->
            store.items.count { it.isAvailable } > store.items.count { !it.isAvailable }
        }.toSet()
    }

    /**
     * Separate items by available flag into lists
     *
     * @param items
     * @return
     */
    fun separateItemsByAvailableFlagIntoLists(items: List<Item>): Pair<List<Item>, List<Item>> {
        return items.partition { it.isAvailable }
    }

    /**
     * Get items available in all stores
     *
     * @param stores
     * @return
     */
    fun getItemsAvailableInAllStores(stores: List<Store>): Set<Item> {
        return stores.map { it.items.toSet() }.reduce { available, items ->
            available.intersect(items)
        }
    }

    /**
     * Map items to stores as available count
     *
     * @param stores
     * @return
     */
    fun mapItemsToStoresAsAvailableCount(stores: List<Store>): Map<Item, Int> {
        return stores.flatMap { store ->
            store.items.filter { it.isAvailable }
        }.groupingBy { it }.eachCount()
    }

    /**
     * Find the most available items in stores
     *
     * @param stores
     * @return
     */
    fun findTheMostAvailableItemsInStores(stores: List<Store>): List<Item> {
        val itemCounts =
            stores.flatMap { it.items.filter { it.isAvailable } }.groupingBy { it }.eachCount()

        val maxCount = itemCounts.values.maxOrNull() ?: return emptyList()

        return itemCounts.filterValues { it == maxCount }.keys.toList()
    }

    /**
     * Find the store with the most available items
     *
     * @param stores
     * @return
     */
    fun findTheStoreWithTheMostAvailableItems(stores: List<Store>): List<Store> {
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
     * @param stores
     * @return
     */
    fun findTheStoreWithTheMostAvailableItems2(stores: List<Store>): List<Store> {
        val maxCount =
            stores.maxOfOrNull { it.items.count { it.isAvailable } } ?: return emptyList()
        return stores.filter { it.items.count { it.isAvailable } == maxCount }
    }
}