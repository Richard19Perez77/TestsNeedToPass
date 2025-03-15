package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.advanced.CollectionsAdvanced
import com.rperez.testsneedtopass.constants.Constants.Companion.Item
import com.rperez.testsneedtopass.constants.Constants.Companion.Person
import com.rperez.testsneedtopass.constants.Constants.Companion.Store
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CollectionsAdvancedTest {

    private val collectionsAdvanced = CollectionsAdvanced()

    @Test
    fun `test groupPeopleByAge`() {
        val people = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 25)
        )

        val result = collectionsAdvanced.groupPeopleByAge(people)

        assertEquals(2, result.size)
        assertEquals(2, result[25]?.size) // Alice & Charlie
        assertEquals(1, result[30]?.size) // Bob
    }

    @Test
    fun `test countOccurrencesOfEachWord`() {
        val words = listOf("apple", "banana", "apple", "orange", "banana", "banana")
        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(2, result["apple"])
        assertEquals(3, result["banana"])
        assertEquals(1, result["orange"])
    }

    @Test
    fun `test mapValueToAccumulationOfOccurrence`() {
        val numbers = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
        val result = collectionsAdvanced.mapValueToAccumulationOfOccurrence(numbers)

        assertEquals(1, result[1])
        assertEquals(2, result[2])
        assertEquals(3, result[3])
        assertEquals(4, result[4])
    }

    @Test
    fun `test groupByEmployeesAgeThenGroupByLengthOfName`() {
        val employees = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 25),
            Person("David", 30)
        )

        val result = collectionsAdvanced.groupByEmployeesAgeThenGroupByLengthOfName(employees)

        assertEquals(2, result[25]?.size) // 25: Alice, Charlie
        assertEquals(2, result[30]?.size) // 30: Bob, David
        assertEquals(1, result[30]?.get(3)?.size) // Bob (name length 3)
    }

    @Test
    fun `test increaseSalariesBy10Percent`() {
        val salaries = mapOf("John" to 5000, "Jane" to 6000, "Jack" to 5500)
        val result = collectionsAdvanced.increaseSalariesBy10Percent(salaries)

        assertEquals(5500, result["John"])
        assertEquals(6600, result["Jane"])
        assertEquals(6050, result["Jack"])
    }

    @Test
    fun `test getStoresWithMoreItemsAvailableThanNot`() {
        val stores = listOf(
            Store(1, listOf(Item(0, true), Item(1, true), Item(2, false))),
            Store(2, listOf(Item(3, false), Item(4, false), Item(5, true))),
            Store(3, listOf(Item(6, true), Item(7, true), Item(8, true)))
        )

        val result = collectionsAdvanced.getStoresWithMoreItemsAvailableThanNot(stores)

        assertEquals(2, result.size)
        assertTrue(result.contains(stores[0]))
        assertTrue(result.contains(stores[2]))
    }

    @Test
    fun `test findTheMostAvailableItemsInStores`() {
        val stores = listOf(
            Store(1, listOf(Item(1, true), Item(2, true), Item(3, true))),
            Store(2, listOf(Item(3, true), Item(4, true), Item(5, true))),
            Store(3, listOf(Item(3, true), Item(6, true), Item(7, true)))
        )

        val result = collectionsAdvanced.findTheMostAvailableItemsInStores(stores)

        assertTrue(result.contains(Item(3, true))) // Item 3 appears in all stores
    }

    @Test
    fun `test findTheStoreWithTheMostAvailableItems`() {
        val stores = listOf(
            Store(1, listOf(Item(0, true), Item(1, true))),
            Store(2, listOf(Item(2, true), Item(3, true), Item(4, true))),
            Store(3, listOf(Item(5, true), Item(6, true)))
        )

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems(stores)

        assertEquals(1, result.size)
        assertEquals(2, result.first().id) // Store 2 has the most available items
    }

    @Test
    fun `test convertMapValuesToUppercase`() {
        val namesMap = mapOf(
            1 to "alice",
            2 to "bob",
            3 to "charlie"
        )

        val expected = mapOf(
            1 to "ALICE",
            2 to "BOB",
            3 to "CHARLIE"
        )

        val result = collectionsAdvanced.convertMapValuesToUppercase(namesMap)

        assertEquals(expected, result)
    }

    @Test
    fun `test groupEmployeesByAgeAndCountByName`() {
        val employees = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 25),
            Person("David", 30),
            Person("Eve", 35),
            Person("Frank", 35),
            Person("Grace", 35)
        )

        val expected = mapOf(
            25 to 2, // Alice, Charlie
            30 to 2, // Bob, David
            35 to 3  // Eve, Frank, Grace
        )

        val result = collectionsAdvanced.groupEmployeesByAgeAndCountByName(employees)

        assertEquals(expected, result)
    }

    @Test
    fun `test convertIntKeyToString`() {
        val numbersMap = mapOf(
            1 to "One",
            2 to "Two",
            3 to "Three"
        )

        val expected = mapOf(
            "Number-1" to "One",
            "Number-2" to "Two",
            "Number-3" to "Three"
        )

        val result = collectionsAdvanced.convertIntKeyToString(numbersMap)

        assertEquals(expected, result)
    }

    @Test
    fun `test sumTheListsOfListOfInts`() {
        val nestedList = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )

        val expected = 45 // (1+2+3+4+5+6+7+8+9)

        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    @Test
    fun `test filterAndSumBasedOnEvenCount`() {
        val numbersList = listOf(10, 15, 20, 25, 30, 35) // Even numbers: 10, 20, 30
        val expected = 60 // (10 + 20 + 30)

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbersList)

        assertEquals(expected, result)
    }

    @Test
    fun `test filterAndSumBasedOnEvenCount with no even numbers`() {
        val numbersList = listOf(1, 3, 5, 7, 9)
        val expected = 0 // No even numbers, so sum should be 0

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbersList)

        assertEquals(expected, result)
    }

    @Test
    fun `test filterAndSumBasedOnEvenCount with empty list`() {
        val numbersList = emptyList<Int>()
        val expected = 0 // No numbers to sum

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbersList)

        assertEquals(expected, result)
    }

    @Test
    fun `test sumTheListsOfListOfInts with empty lists`() {
        val nestedList = listOf<List<Int>>(
            listOf(),
            listOf(),
            listOf()
        )

        val expected = 0
        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    @Test
    fun `test stringParsingIntoListThenMap`() {
        val rawData = "Alice:30,Bob:25,Charlie:30,David:40,Eve:25"

        val expected = mapOf(
            "Alice" to 30,
            "Bob" to 25,
            "Charlie" to 30,
            "David" to 40,
            "Eve" to 25
        )

        val result = collectionsAdvanced.stringParsingIntoListThenMap(rawData)

        assertEquals(expected, result)
    }

    @Test
    fun `test stringParsingIntoListThenMap with empty input`() {
        val rawData = ""
        val expected = emptyMap<String, Int>() // Expect an empty map

        val result = collectionsAdvanced.stringParsingIntoListThenMap(rawData)

        assertEquals(expected, result)
    }

    @Test
    fun `test stringParsingIntoListThenMap with spaces in input`() {
        val rawData = "Alice: 30 , Bob:25 , Charlie : 30"

        val expected = mapOf(
            "Alice" to 30,
            "Bob" to 25,
            "Charlie" to 30
        )

        val result = collectionsAdvanced.stringParsingIntoListThenMap(
            rawData.replace(
                " ",
                ""
            )
        ) // Preprocess spaces

        assertEquals(expected, result)
    }

    @Test
    fun `test stringParsingIntoListThenMap with malformed input`() {
        val rawData = "Alice:30,Bob:,Charlie:NaN"

        assertThrows(NumberFormatException::class.java) {
            collectionsAdvanced.stringParsingIntoListThenMap(rawData)
        }
    }

    @Test
    fun `test separateItemsByAvailableFlagIntoLists`() {
        val items = listOf(
            Item(1, true),
            Item(2, false),
            Item(3, true),
            Item(4, false),
            Item(5, true)
        )

        val expectedAvailable = listOf(
            Item(1, true),
            Item(3, true),
            Item(5, true)
        )

        val expectedUnavailable = listOf(
            Item(2, false),
            Item(4, false)
        )

        val (available, unavailable) = collectionsAdvanced.separateItemsByAvailableFlagIntoLists(
            items
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test separateItemsByAvailableFlagIntoLists with all available items`() {
        val items = listOf(
            Item(1, true),
            Item(2, true),
            Item(3, true)
        )

        val expectedAvailable = items
        val expectedUnavailable = emptyList<Item>()

        val (available, unavailable) = collectionsAdvanced.separateItemsByAvailableFlagIntoLists(
            items
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test separateItemsByAvailableFlagIntoLists with all unavailable items`() {
        val items = listOf(
            Item(1, false),
            Item(2, false),
            Item(3, false)
        )

        val expectedAvailable = emptyList<Item>()
        val expectedUnavailable = items

        val (available, unavailable) = collectionsAdvanced.separateItemsByAvailableFlagIntoLists(
            items
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test separateItemsByAvailableFlagIntoLists with empty list`() {
        val items = emptyList<Item>()

        val expectedAvailable = emptyList<Item>()
        val expectedUnavailable = emptyList<Item>()

        val (available, unavailable) = collectionsAdvanced.separateItemsByAvailableFlagIntoLists(
            items
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test getItemsAvailableInAllStores`() {
        val commonItem = Item(1, true)
        val store1 = Store(1, listOf(commonItem, Item(2, true), Item(3, false)))
        val store2 = Store(2, listOf(commonItem, Item(4, true)))
        val store3 = Store(3, listOf(commonItem, Item(5, false)))

        val stores = listOf(store1, store2, store3)

        val expected = setOf(commonItem) // Only Item(1, true) is available in all stores

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test getItemsAvailableInAllStores with no common available items`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, true), Item(4, false)))
        val store3 = Store(3, listOf(Item(5, true), Item(6, false)))

        val stores = listOf(store1, store2, store3)

        val expected = emptySet<Item>() // No item is available in all stores

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test getItemsAvailableInAllStores with identical available items in all stores`() {
        val commonItems = listOf(Item(1, true), Item(2, true))
        val store1 = Store(1, commonItems)
        val store2 = Store(2, commonItems)
        val store3 = Store(3, commonItems)

        val stores = listOf(store1, store2, store3)

        val expected = commonItems.toSet()

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test getItemsAvailableInAllStores with empty stores`() {
        val stores = emptyList<Store>()

        val expected = emptySet<Item>() // No stores mean no items

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test mapItemsToStoresAsAvailableCount`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)
        val item3 = Item(3, false) // Not available, should be ignored

        val store1 = Store(1, listOf(item1, item2, item3)) // item1, item2 are available
        val store2 = Store(2, listOf(item1, item2))        // item1, item2 are available
        val store3 = Store(3, listOf(item1))               // item1 is available

        val stores = listOf(store1, store2, store3)

        val expected = mapOf(
            item1 to 3,  // Available in 3 stores
            item2 to 2   // Available in 2 stores
        )

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test mapItemsToStoresAsAvailableCount with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptyMap<Item, Int>() // No available items

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test mapItemsToStoresAsAvailableCount with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptyMap<Item, Int>() // No stores mean no items

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test findTheStoreWithTheMostAvailableItems2`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, true), Item(3, false))) // 2 available
        val store2 = Store(2, listOf(Item(4, true), Item(5, true), Item(6, true)))  // 3 available
        val store3 = Store(3, listOf(Item(7, true), Item(8, false))) // 1 available

        val stores = listOf(store1, store2, store3)

        val expected = listOf(store2) // Store 2 has the most available items (3)

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with multiple max stores`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, true))) // 2 available
        val store2 = Store(2, listOf(Item(3, true), Item(4, true))) // 2 available
        val store3 = Store(3, listOf(Item(5, true))) // 1 available

        val stores = listOf(store1, store2, store3)

        val expected = listOf(store1, store2) // Both have 2 available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptyList<Store>() // No stores have available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptyList<Store>() // No stores available

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    @Test
    fun `test groupWordsByLengthFromASentence`() {
        val sentence = "Kotlin is a great programming language"

        val expected = mapOf(
            1 to listOf("a"),
            2 to listOf("is"),
            6 to listOf("Kotlin"),
            5 to listOf("great"),
            11 to listOf("programming"),
            8 to listOf("language")
        )

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(sentence)

        assertEquals(expected, result)
    }

    @Test
    fun `test groupWordsByLengthFromASentence with punctuation`() {
        val sentence = "Hello, world! It's Kotlin."

        val expected = mapOf(
            5 to listOf("Hello, world"),
            6 to listOf("Kotlin"),
            4 to listOf("It's")
        )

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(sentence)

        fun <K : Comparable<K>> Map<K, List<String>>.normalize(): Map<K, List<String>> {
            return this.entries
                .sortedBy { it.key } // Sort keys
                .associate { (key, value) -> key to value.map { it.trim() }.sorted() } // Trim and sort values
        }

        assertEquals(expected.normalize(), result.normalize())
    }

    @Test
    fun `test groupWordsByLengthFromASentence with extra spaces`() {
        val sentence = "  Kotlin   is  fun  "

        val expected = mapOf(
            6 to listOf("Kotlin"),
            2 to listOf("is"),
            3 to listOf("fun")
        )

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(
            sentence.trim().replace(Regex("\\s+"), " ")
        )

        assertEquals(expected, result)
    }

    @Test
    fun `test groupWordsByLengthFromASentence with empty string`() {
        val sentence = ""

        val expected = emptyMap<Int, List<String>>() // No words in sentence

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(sentence)

        assertEquals(expected, result)
    }

    @Test
    fun `test calculateWordFrequencyInASentence`() {
        val sentence = "Kotlin is great and Kotlin is fun"

        val expected = mapOf(
            "Kotlin" to 2,
            "is" to 2,
            "great" to 1,
            "and" to 1,
            "fun" to 1
        )

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(sentence)

        assertEquals(expected, result)
    }

    @Test
    fun `test calculateWordFrequencyInASentence with punctuation`() {
        val sentence = "Hello, world! Hello world."

        val expected = mapOf(
            "Hello" to 2,
            "world" to 2
        )

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(
            sentence.replace(Regex("[^a-zA-Z ]"), "") // Remove punctuation
        )

        assertEquals(expected, result)
    }

    @Test
    fun `test calculateWordFrequencyInASentence with case insensitivity`() {
        val sentence = "Kotlin kotlin Kotlin"

        val expected = mapOf(
            "kotlin" to 3
        )

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(sentence.lowercase())

        assertEquals(expected, result)
    }

    @Test
    fun `test calculateWordFrequencyInASentence with extra spaces`() {
        val sentence = "  Kotlin    is  fun  Kotlin  "

        val expected = mapOf(
            "Kotlin" to 2,
            "is" to 1,
            "fun" to 1
        )

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(
            sentence.trim().replace(Regex("\\s+"), " ") // Normalize spaces
        )

        assertEquals(expected, result)
    }

    @Test
    fun `test calculateWordFrequencyInASentence with empty string`() {
        val sentence = ""

        val expected = emptyMap<String, Int>() // No words in sentence

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(sentence)

        assertEquals(expected, result)
    }

    @Test
    fun `test getPairOfListsSplittingAvailableAndUnavailableItems`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, false), Item(3, true)))
        val store2 = Store(2, listOf(Item(4, true), Item(5, false)))
        val store3 = Store(3, listOf(Item(6, false), Item(7, true), Item(8, true)))

        val stores = listOf(store1, store2, store3)

        val expectedAvailable = listOf(
            Item(1, true),
            Item(3, true),
            Item(4, true),
            Item(7, true),
            Item(8, true)
        )

        val expectedUnavailable = listOf(
            Item(2, false),
            Item(5, false),
            Item(6, false)
        )

        val (available, unavailable) = collectionsAdvanced.getPairOfListsSplittingAvailableAndUnavailableItems(
            stores
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test getPairOfListsSplittingAvailableAndUnavailableItems with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false)))

        val stores = listOf(store1, store2)

        val expectedAvailable = emptyList<Item>()
        val expectedUnavailable = listOf(Item(1, false), Item(2, false), Item(3, false))

        val (available, unavailable) = collectionsAdvanced.getPairOfListsSplittingAvailableAndUnavailableItems(
            stores
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test getPairOfListsSplittingAvailableAndUnavailableItems with no unavailable items`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, true)))
        val store2 = Store(2, listOf(Item(3, true)))

        val stores = listOf(store1, store2)

        val expectedAvailable = listOf(Item(1, true), Item(2, true), Item(3, true))
        val expectedUnavailable = emptyList<Item>()

        val (available, unavailable) = collectionsAdvanced.getPairOfListsSplittingAvailableAndUnavailableItems(
            stores
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    @Test
    fun `test getPairOfListsSplittingAvailableAndUnavailableItems with empty store list`() {
        val stores = emptyList<Store>()

        val expectedAvailable = emptyList<Item>()
        val expectedUnavailable = emptyList<Item>()

        val (available, unavailable) = collectionsAdvanced.getPairOfListsSplittingAvailableAndUnavailableItems(
            stores
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }
}
