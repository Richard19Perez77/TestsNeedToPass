package com.rperez.testsneedtopass.advanced

class CollectionsAdvanced {
    data class Person(val name: String, val age: Int)

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
        // group by value, fold over each occurrence into sum from 0
        return numbers.groupingBy { it }.fold(0) { acc, element -> acc + element }
    }

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

    val salaries = mapOf("John" to 5000, "Jane" to 6000, "Jack" to 5500)

    fun increaseSalariesBy10Percent(): Map<String, Double> {
        return salaries.mapValues { (_, salary) -> (salary * 1.1) }
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

    val numbersMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")

    /**
     * Convert int key to string
     *
     * @return
     */
    fun convertIntKeyToString(): Map<String, String> {
        return numbersMap.mapKeys { (key, _) -> "Number-$key" }
    }

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

    val numbersList = listOf(10, 15, 20, 25, 30, 35)

    /**
     * Filter and sum based on event count
     *
     * @return
     */
    fun filterAndSumBasedOnEventCount(): Int {
        return numbersList.filter { it % 2 == 0 }.sum()
    }

    data class Item(var id: Int = 0, var isAvailable: Boolean = false)

    var items = listOf<Item>(
        Item(0, true),
        Item(1, true),
        Item(2, false),
        Item(3, true)
    )

    var items2 = listOf<Item>(
        Item(0, true),
        Item(1, false),
        Item(2, false),
        Item(3, false)
    )

    var items3 = listOf<Item>(
        Item(0, true),
        Item(1, true),
        Item(2, false),
        Item(3, false)
    )

    data class Store(var id: Int = 0, var items: List<Item> = listOf<Item>())

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
        //val (available, unavailable) = items.partition { it.available }
        return items.partition { it.isAvailable }
    }

    /**
     * Get stores with more items available than not
     *
     * @return
     */
    fun getStoresWithMoreItemsAvailableThanNot(): Set<Store> {
        return stores.filter { // get stores with more in stock than not
            val (available, unavailable) = it.items.partition {
                it.isAvailable // split into tow lists based on available
            }
            available.size > unavailable.size// filter condition
        }.toSet() // ensures unique stores
    }

    fun getItemsAvailableInAllStores(): Set<Item> {
        return stores.map { it.items.toSet() }
            .reduce { available, items ->
                available.intersect(items)
            }
    }
}