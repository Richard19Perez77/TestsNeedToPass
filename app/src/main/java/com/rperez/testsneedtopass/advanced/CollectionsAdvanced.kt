package com.rperez.testsneedtopass.advanced

/**
 * Collections advanced
 *
 * @constructor Create empty Collections advanced
 */
class CollectionsAdvanced {

    /**
     * Person
     *
     * @property name
     * @property age
     * @constructor Create empty Person
     */
    data class Person(val name: String, val age: Int)

    /**
     * People
     */
    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 25),
        Person("David", 30),
        Person("Eve", 35)
    )

    /**
     * Group people by age
     *
     * @return
     */
    fun groupPeopleByAge(): Map<Int, List<Person>> {
        return people.groupBy { it.age }
    }

    val words = listOf("apple", "banana", "apple", "orange", "banana", "banana")

    /**
     * Count occurrences of each word
     *
     * @return
     */
    fun countOccurrencesOfEachWord(): Map<String, Int> {
        return words.groupingBy { it }.eachCount()
    }

    val numbers = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)

    /**
     * Map value to accumulation of occurrence
     *
     * @return
     */
    fun mapValueToAccumulationOfOccurrence(): Map<Int, Int> {
        return numbers.groupingBy { it }.fold(0) { acc, _ -> acc + 1 }
    }

    /**
     * Employees
     */
    val employees = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 25),
        Person("David", 30),
        Person("Eve", 35),
        Person("Frank", 35)
    )

    /**
     * Group by employees age then group by length of name
     *
     * @return
     */
    fun groupByEmployeesAgeThenGroupByLengthOfName(): Map<Int, Map<Int, List<Person>>> {
        return employees.groupBy { it.age }
            .mapValues { (_, people) -> people.groupBy { it.name.length } }
    }

    val names = mapOf(1 to "alice", 2 to "bob", 3 to "charlie")

    /**
     * Convert map values to uppercase
     *
     * @return
     */
    fun convertMapValuesToUppercase(): Map<Int, String> {
        return names.mapValues { (_, value) -> value.uppercase() }
    }

    /**
     * Salaries
     */
    val salaries = mapOf("John" to 5000, "Jane" to 6000, "Jack" to 5500)

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
     * Numbers map
     */
    val numbersMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")

    /**
     * Convert int key to string
     *
     * @return
     */
    fun convertIntKeyToString(): Map<String, String> {
        return numbersMap.mapKeys { (key, _) -> "Number-$key" }
    }

    /**
     * Nested list
     */
    val nestedList = listOf(
        listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)
    )

    /**
     * Sum the lists of List of ints
     *
     * @return
     */
    fun sumTheListsOfListOfInts(): Int {
        return nestedList.flatten().sum()
    }

    /**
     * Raw data
     */
    val rawData = "Alice:30,Bob:25,Charlie:30,David:40,Eve:25"

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
     * Sentence
     */
    val sentence = "Kotlin is a great programming language"

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
     * Numbers list
     */
    val numbersList = listOf(10, 15, 20, 25, 30, 35)

    /**
     * Filter and sum based on event count
     *
     * @return
     */
    fun filterAndSumBasedOnEventCount(): Int {
        return numbersList.filter { it % 2 == 0 }.sum()
    }

    /**
     * Item
     *
     * @property id
     * @property isAvailable
     * @constructor Create empty Item
     */
    data class Item(var id: Int = 0, var isAvailable: Boolean = false)

    /**
     * Items
     */
    var items = listOf<Item>(
        Item(0, true),
        Item(1, true),
        Item(2, false),
        Item(3, true)
    )

    /**
     * Items2
     */
    var items2 = listOf<Item>(
        Item(0, true),
        Item(1, false),
        Item(2, false),
        Item(3, false)
    )

    /**
     * Items3
     */
    var items3 = listOf<Item>(
        Item(0, true),
        Item(1, true),
        Item(2, false),
        Item(3, false)
    )

    /**
     * Store
     *
     * @property id
     * @property items
     * @constructor Create empty Store
     */
    data class Store(var id: Int = 0, var items: List<Item> = listOf<Item>())

    /**
     * Stores
     */
    var stores = listOf<Store>(
        Store(1, items),
        Store(2, items2),
        Store(3, items3)
    )

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