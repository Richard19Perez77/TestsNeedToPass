package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.advanced.CollectionsAdvanced
import com.rperez.testsneedtopass.constants.Constants.Companion.Item
import com.rperez.testsneedtopass.constants.Constants.Companion.Person
import com.rperez.testsneedtopass.constants.Constants.Companion.Store
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

/**
 * Collections advanced test
 *
 * @constructor Create empty Collections advanced test
 */
class CollectionsAdvancedTest {

    /**
     * Collections advanced
     */
    private val collectionsAdvanced = CollectionsAdvanced()

    /**
     * Test group people by age
     *
     */
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

    /**
     * Test group people by age with multiple age groups
     *
     */
    @Test
    fun `test groupPeopleByAge with multiple age groups`() {
        val people = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 25),
            Person("David", 30),
            Person("Eve", 35)
        )

        val expected = mapOf(
            25 to listOf(Person("Alice", 25), Person("Charlie", 25)),
            30 to listOf(Person("Bob", 30), Person("David", 30)),
            35 to listOf(Person("Eve", 35))
        )

        val result = collectionsAdvanced.groupPeopleByAge(people)

        assertEquals(expected, result)
    }

    /**
     * Test group people by age with all same age
     *
     */
    @Test
    fun `test groupPeopleByAge with all same age`() {
        val people = listOf(
            Person("Alice", 30),
            Person("Bob", 30),
            Person("Charlie", 30)
        )

        val expected = mapOf(
            30 to listOf(
                Person("Alice", 30),
                Person("Bob", 30),
                Person("Charlie", 30)
            )
        )

        val result = collectionsAdvanced.groupPeopleByAge(people)

        assertEquals(expected, result)
    }

    /**
     * Test group people by age with one person
     *
     */
    @Test
    fun `test groupPeopleByAge with one person`() {
        val people = listOf(Person("Alice", 25))

        val expected = mapOf(
            25 to listOf(Person("Alice", 25))
        )

        val result = collectionsAdvanced.groupPeopleByAge(people)

        assertEquals(expected, result)
    }

    /**
     * Test group people by age with empty list
     *
     */
    @Test
    fun `test groupPeopleByAge with empty list`() {
        val people = emptyList<Person>()

        val expected = emptyMap<Int, List<Person>>()

        val result = collectionsAdvanced.groupPeopleByAge(people)

        assertEquals(expected, result)
    }

    /**
     * Test count occurrences of each word with multiple occurrences
     *
     */
    @Test
    fun `test countOccurrencesOfEachWord with multiple occurrences`() {
        val words = listOf("apple", "banana", "apple", "orange", "banana", "banana")

        val expected = mapOf(
            "apple" to 2,
            "banana" to 3,
            "orange" to 1
        )

        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(expected, result)
    }

    /**
     * Test count occurrences of each word with unique words
     *
     */
    @Test
    fun `test countOccurrencesOfEachWord with unique words`() {
        val words = listOf("apple", "banana", "orange", "grape")

        val expected = mapOf(
            "apple" to 1,
            "banana" to 1,
            "orange" to 1,
            "grape" to 1
        )

        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(expected, result)
    }

    /**
     * Test count occurrences of each word with a single word repeated
     *
     */
    @Test
    fun `test countOccurrencesOfEachWord with a single word repeated`() {
        val words = listOf("apple", "apple", "apple", "apple")

        val expected = mapOf("apple" to 4)

        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(expected, result)
    }

    /**
     * Test count occurrences of each word with empty list
     *
     */
    @Test
    fun `test countOccurrencesOfEachWord with empty list`() {
        val words = emptyList<String>()

        val expected = emptyMap<String, Int>()

        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(expected, result)
    }

    /**
     * Test count occurrences of each word with case sensitivity
     *
     */
    @Test
    fun `test countOccurrencesOfEachWord with case sensitivity`() {
        val words = listOf("apple", "Apple", "APPLE", "banana", "Banana")

        val expected = mapOf(
            "apple" to 1,
            "Apple" to 1,
            "APPLE" to 1,
            "banana" to 1,
            "Banana" to 1
        )

        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(expected, result)
    }

    /**
     * Test map value to accumulation of occurrence with multiple occurrences
     *
     */
    @Test
    fun `test mapValueToAccumulationOfOccurrence with multiple occurrences`() {
        val numbers = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)

        val expected = mapOf(
            1 to 1,
            2 to 2,
            3 to 3,
            4 to 4
        )

        val result = collectionsAdvanced.mapValueToAccumulationOfOccurrence(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test map value to accumulation of occurrence with unique numbers
     *
     */
    @Test
    fun `test mapValueToAccumulationOfOccurrence with unique numbers`() {
        val numbers = listOf(5, 10, 15, 20)

        val expected = mapOf(
            5 to 1,
            10 to 1,
            15 to 1,
            20 to 1
        )

        val result = collectionsAdvanced.mapValueToAccumulationOfOccurrence(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test map value to accumulation of occurrence with single repeated number
     *
     */
    @Test
    fun `test mapValueToAccumulationOfOccurrence with single repeated number`() {
        val numbers = listOf(42, 42, 42, 42)

        val expected = mapOf(42 to 4)

        val result = collectionsAdvanced.mapValueToAccumulationOfOccurrence(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test map value to accumulation of occurrence with empty list
     *
     */
    @Test
    fun `test mapValueToAccumulationOfOccurrence with empty list`() {
        val numbers = emptyList<Int>()

        val expected = emptyMap<Int, Int>()

        val result = collectionsAdvanced.mapValueToAccumulationOfOccurrence(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test group by employees age then group by length of name with multiple age groups
     *
     */
    @Test
    fun `test groupByEmployeesAgeThenGroupByLengthOfName with multiple age groups`() {
        val employees = listOf(
            Person("Alice", 25),  // 5 chars
            Person("Bob", 30),    // 3 chars
            Person("Charlie", 25),// 7 chars
            Person("David", 30),  // 5 chars
            Person("Eve", 35)     // 3 chars
        )

        val expected = mapOf(
            25 to mapOf(
                5 to listOf(Person("Alice", 25)),
                7 to listOf(Person("Charlie", 25))
            ),
            30 to mapOf(
                3 to listOf(Person("Bob", 30)),
                5 to listOf(Person("David", 30))
            ),
            35 to mapOf(
                3 to listOf(Person("Eve", 35))
            )
        )

        val result = collectionsAdvanced.groupByEmployeesAgeThenGroupByLengthOfName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test group by employees age then group by length of name with same age
     *
     */
    @Test
    fun `test groupByEmployeesAgeThenGroupByLengthOfName with same age`() {
        val employees = listOf(
            Person("John", 30),   // 4 chars
            Person("Jane", 30),   // 4 chars
            Person("Jim", 30)     // 3 chars
        )

        val expected = mapOf(
            30 to mapOf(
                3 to listOf(Person("Jim", 30)),
                4 to listOf(Person("John", 30), Person("Jane", 30))
            )
        )

        val result = collectionsAdvanced.groupByEmployeesAgeThenGroupByLengthOfName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test group by employees age then group by length of name with one employee
     *
     */
    @Test
    fun `test groupByEmployeesAgeThenGroupByLengthOfName with one employee`() {
        val employees = listOf(Person("Alice", 25))

        val expected = mapOf(
            25 to mapOf(
                5 to listOf(Person("Alice", 25))
            )
        )

        val result = collectionsAdvanced.groupByEmployeesAgeThenGroupByLengthOfName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test group by employees age then group by length of name with empty list
     *
     */
    @Test
    fun `test groupByEmployeesAgeThenGroupByLengthOfName with empty list`() {
        val employees = emptyList<Person>()

        val expected = emptyMap<Int, Map<Int, List<Person>>>()

        val result = collectionsAdvanced.groupByEmployeesAgeThenGroupByLengthOfName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test convert map values to uppercase with multiple values
     *
     */
    @Test
    fun `test convertMapValuesToUppercase with multiple values`() {
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


    /**
     * Test convert map values to uppercase with mixed case values
     *
     */
    @Test
    fun `test convertMapValuesToUppercase with mixed case values`() {
        val namesMap = mapOf(
            1 to "Alice",
            2 to "bOb",
            3 to "CHARLIE"
        )

        val expected = mapOf(
            1 to "ALICE",
            2 to "BOB",
            3 to "CHARLIE"
        )

        val result = collectionsAdvanced.convertMapValuesToUppercase(namesMap)

        assertEquals(expected, result)
    }

    /**
     * Test convert map values to uppercase with already uppercase values
     *
     */
    @Test
    fun `test convertMapValuesToUppercase with already uppercase values`() {
        val namesMap = mapOf(
            1 to "ALICE",
            2 to "BOB",
            3 to "CHARLIE"
        )

        val expected = namesMap // The result should be the same

        val result = collectionsAdvanced.convertMapValuesToUppercase(namesMap)

        assertEquals(expected, result)
    }

    /**
     * Test convert map values to uppercase with numbers and special characters
     *
     */
    @Test
    fun `test convertMapValuesToUppercase with numbers and special characters`() {
        val namesMap = mapOf(
            1 to "alice123",
            2 to "bob@home",
            3 to "charlie!"
        )

        val expected = mapOf(
            1 to "ALICE123",
            2 to "BOB@HOME",
            3 to "CHARLIE!"
        )

        val result = collectionsAdvanced.convertMapValuesToUppercase(namesMap)

        assertEquals(expected, result)
    }

    /**
     * Test convert map values to uppercase with empty map
     *
     */
    @Test
    fun `test convertMapValuesToUppercase with empty map`() {
        val namesMap = emptyMap<Int, String>()

        val expected = emptyMap<Int, String>()

        val result = collectionsAdvanced.convertMapValuesToUppercase(namesMap)

        assertEquals(expected, result)
    }

    /**
     * Test increase salaries by10percent with multiple employees
     *
     */
    @Test
    fun `test increaseSalariesBy10Percent with multiple employees`() {
        val salaries = mapOf(
            "Alice" to 5000,
            "Bob" to 6000,
            "Charlie" to 7000
        )

        val expected = mapOf(
            "Alice" to 5500,  // 5000 * 1.1 = 5500
            "Bob" to 6600,    // 6000 * 1.1 = 6600
            "Charlie" to 7700 // 7000 * 1.1 = 7700
        )

        val result = collectionsAdvanced.increaseSalariesBy10Percent(salaries)

        assertEquals(expected, result)
    }


    /**
     * Test increase salaries by10percent with rounding cases
     *
     */
    @Test
    fun `test increaseSalariesBy10Percent with rounding cases`() {
        val salaries = mapOf(
            "David" to 3333,
            "Eve" to 7777
        )

        val expected = mapOf(
            "David" to 3666,  // 3333 * 1.1 = 3666.3 → 3666
            "Eve" to 8554     // 7777 * 1.1 = 8554.7 → 8554
        )

        val result = collectionsAdvanced.increaseSalariesBy10Percent(salaries)

        assertEquals(expected, result)
    }

    /**
     * Test increase salaries by10percent with negative salary
     *
     */
    @Test
    fun `test increaseSalariesBy10Percent with negative salary`() {
        val salaries = mapOf(
            "Grace" to -1000
        )

        val expected = mapOf(
            "Grace" to -1100 // -1000 * 1.1 = -1100
        )

        val result = collectionsAdvanced.increaseSalariesBy10Percent(salaries)

        assertEquals(expected, result)
    }

    /**
     * Test increase salaries by10percent with empty map
     *
     */
    @Test
    fun `test increaseSalariesBy10Percent with empty map`() {
        val salaries = emptyMap<String, Int>()

        val expected = emptyMap<String, Int>()

        val result = collectionsAdvanced.increaseSalariesBy10Percent(salaries)

        assertEquals(expected, result)
    }

    /**
     * Test group employees by age and count by name with multiple age groups
     *
     */
    @Test
    fun `test groupEmployeesByAgeAndCountByName with multiple age groups`() {
        val employees = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 25),
            Person("David", 30),
            Person("Eve", 35)
        )

        val expected = mapOf(
            25 to 2, // Alice, Charlie
            30 to 2, // Bob, David
            35 to 1  // Eve
        )

        val result = collectionsAdvanced.groupEmployeesByAgeAndCountByName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test group employees by age and count by name with same age
     *
     */
    @Test
    fun `test groupEmployeesByAgeAndCountByName with same age`() {
        val employees = listOf(
            Person("Alice", 30),
            Person("Bob", 30),
            Person("Charlie", 30)
        )

        val expected = mapOf(
            30 to 3 // Alice, Bob, Charlie
        )

        val result = collectionsAdvanced.groupEmployeesByAgeAndCountByName(employees)

        assertEquals(expected, result)
    }


    /**
     * Test group employees by age and count by name with one employee
     *
     */
    @Test
    fun `test groupEmployeesByAgeAndCountByName with one employee`() {
        val employees = listOf(Person("Alice", 25))

        val expected = mapOf(
            25 to 1
        )

        val result = collectionsAdvanced.groupEmployeesByAgeAndCountByName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test group employees by age and count by name with empty list
     *
     */
    @Test
    fun `test groupEmployeesByAgeAndCountByName with empty list`() {
        val employees = emptyList<Person>()

        val expected = emptyMap<Int, Int>()

        val result = collectionsAdvanced.groupEmployeesByAgeAndCountByName(employees)

        assertEquals(expected, result)
    }

    /**
     * Test convert int key to string with empty map
     *
     */
    @Test
    fun `test convertIntKeyToString with empty map`() {
        val numbersMap = emptyMap<Int, String>()

        val expected = emptyMap<String, String>()

        val result = collectionsAdvanced.convertIntKeyToString(numbersMap)

        assertEquals(expected, result)
    }

    /**
     * Test convert int key to string with multiple keys
     *
     */
    @Test
    fun `test convertIntKeyToString with multiple keys`() {
        val numbersMap = mapOf(
            1 to "One",
            2 to "Two",
            3 to "Three"
        )

        val expected = mapOf(
            "Number 1" to "One",
            "Number 2" to "Two",
            "Number 3" to "Three"
        )

        val result = collectionsAdvanced.convertIntKeyToString(numbersMap)

        assertEquals(expected, result)
    }

    /**
     * Test convert int key to string with single entry
     *
     */
    @Test
    fun `test convertIntKeyToString with single entry`() {
        val numbersMap = mapOf(5 to "Five")

        val expected = mapOf("Number 5" to "Five")

        val result = collectionsAdvanced.convertIntKeyToString(numbersMap)

        assertEquals(expected, result)
    }

    /**
     * Test convert int key to string with negative keys
     *
     */
    @Test
    fun `test convertIntKeyToString with negative keys`() {
        val numbersMap = mapOf(
            -1 to "Negative One",
            -2 to "Negative Two"
        )

        val expected = mapOf(
            "Number -1" to "Negative One",
            "Number -2" to "Negative Two"
        )

        val result = collectionsAdvanced.convertIntKeyToString(numbersMap)

        assertEquals(expected, result)
    }


    /**
     * Test count occurrences of each word
     *
     */
    @Test
    fun `test countOccurrencesOfEachWord`() {
        val words = listOf("apple", "banana", "apple", "orange", "banana", "banana")
        val result = collectionsAdvanced.countOccurrencesOfEachWord(words)

        assertEquals(2, result["apple"])
        assertEquals(3, result["banana"])
        assertEquals(1, result["orange"])
    }

    /**
     * Test map value to accumulation of occurrence
     *
     */
    @Test
    fun `test mapValueToAccumulationOfOccurrence`() {
        val numbers = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
        val result = collectionsAdvanced.mapValueToAccumulationOfOccurrence(numbers)

        assertEquals(1, result[1])
        assertEquals(2, result[2])
        assertEquals(3, result[3])
        assertEquals(4, result[4])
    }

    /**
     * Test group by employees age then group by length of name
     *
     */
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

    /**
     * Test increase salaries by10percent
     *
     */
    @Test
    fun `test increaseSalariesBy10Percent`() {
        val salaries = mapOf("John" to 5000, "Jane" to 6000, "Jack" to 5500)
        val result = collectionsAdvanced.increaseSalariesBy10Percent(salaries)

        assertEquals(5500, result["John"])
        assertEquals(6600, result["Jane"])
        assertEquals(6050, result["Jack"])
    }

    /**
     * Test get stores with more items available than not
     *
     */
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

    /**
     * Test find the most available items in stores
     *
     */
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

    /**
     * Test find the store with the most available items
     *
     */
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

    /**
     * Test convert map values to uppercase
     *
     */
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

    /**
     * Test group employees by age and count by name
     *
     */
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

    /**
     * Test convert int key to string
     *
     */
    @Test
    fun `test convertIntKeyToString`() {
        val numbersMap = mapOf(
            1 to "One",
            2 to "Two",
            3 to "Three"
        )

        val expected = mapOf(
            "Number 1" to "One",
            "Number 2" to "Two",
            "Number 3" to "Three"
        )

        val result = collectionsAdvanced.convertIntKeyToString(numbersMap)

        assertEquals(expected, result)
    }

    /**
     * Test sum the lists of list of ints with multiple lists
     *
     */
    @Test
    fun `test sumTheListsOfListOfInts with multiple lists`() {
        val nestedList = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )

        val expected = 45 // (1+2+3+4+5+6+7+8+9)

        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    /**
     * Test sum the lists of list of ints with negative numbers
     *
     */
    @Test
    fun `test sumTheListsOfListOfInts with negative numbers`() {
        val nestedList = listOf(
            listOf(-1, -2, -3),
            listOf(4, 5, 6),
            listOf(-7, 8, -9)
        )

        val expected = 1 // (-1 -2 -3 +4 +5 +6 -7 +8 -9) = 1

        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    /**
     * Test sum the lists of list of ints with some empty lists
     *
     */
    @Test
    fun `test sumTheListsOfListOfInts with some empty lists`() {
        val nestedList = listOf(
            listOf(),
            listOf(1, 2, 3),
            listOf()
        )

        val expected = 6 // (1+2+3)

        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    /**
     * Test sum the lists of list of ints with fully empty list
     *
     */
    @Test
    fun `test sumTheListsOfListOfInts with fully empty list`() {
        val nestedList = emptyList<List<Int>>() // No elements

        val expected = 0 // Sum of nothing is 0

        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    /**
     * Test sum the lists of list of ints with only zeros
     *
     */
    @Test
    fun `test sumTheListsOfListOfInts with only zeros`() {
        val nestedList = listOf(
            listOf(0, 0, 0),
            listOf(0, 0, 0)
        )

        val expected = 0 // Sum of all zeros is 0

        val result = collectionsAdvanced.sumTheListsOfListOfInts(nestedList)

        assertEquals(expected, result)
    }

    /**
     * Test string parsing into list then map with valid data
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with valid data`() {
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

    /**
     * Test string parsing into list then map with spaces around data
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with spaces around data`() {
        val rawData = " Alice : 30 , Bob:25 ,Charlie: 30 , David: 40 , Eve:25 "

        val expected = mapOf(
            "Alice" to 30,
            "Bob" to 25,
            "Charlie" to 30,
            "David" to 40,
            "Eve" to 25
        )

        val result = collectionsAdvanced.stringParsingIntoListThenMap(
            rawData.replace(" ", "") // Preprocess spaces
        )

        assertEquals(expected, result)
    }

    /**
     * Test string parsing into list then map with malformed data
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with malformed data`() {
        val rawData = "Alice:30,Bob:,Charlie:NaN"

        assertThrows(NumberFormatException::class.java) {
            collectionsAdvanced.stringParsingIntoListThenMap(rawData)
        }
    }

    /**
     * Test string parsing into list then map with duplicate keys
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with duplicate keys`() {
        val rawData = "Alice:30,Bob:25,Alice:35"

        val expected = mapOf(
            "Alice" to 35, // Last occurrence should overwrite previous
            "Bob" to 25
        )

        val result = collectionsAdvanced.stringParsingIntoListThenMap(rawData)

        assertEquals(expected, result)
    }

    /**
     * Test string parsing into list then map with non-numeric values
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with non-numeric values`() {
        val rawData = "Alice:30,Bob:twentyfive,Charlie:40"

        assertThrows(NumberFormatException::class.java) {
            collectionsAdvanced.stringParsingIntoListThenMap(rawData)
        }
    }

    /**
     * Test group words by length from a sentence with normal sentence
     *
     */
    @Test
    fun `test groupWordsByLengthFromASentence with normal sentence`() {
        val sentence = "Kotlin is great and functional"

        val expected = mapOf(
            6 to listOf("Kotlin"),
            2 to listOf("is"),
            5 to listOf("great"),
            3 to listOf("and"),
            10 to listOf("functional")
        )

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(sentence)

        expected.forEach { (key, expectedValues) ->
            val actualValues = result[key] ?: emptyList()
            assertTrue(
                expectedValues.sorted() == actualValues.sorted(),
            )
        }
    }

    /**
     * Test group words by length from a sentence with punctuation
     *
     */
    @Test
    fun `test groupWordsByLengthFromASentence with punctuation`() {
        val sentence = "Hello, world! It's Kotlin."

        val expected = mapOf(
            5 to listOf("Hello", "world"),
            6 to listOf("Kotlin"),
            4 to listOf("It's")
        )

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(sentence)

        expected.forEach { (key, expectedValues) ->
            val actualValues = result[key] ?: emptyList()
            assertTrue(
                expectedValues.sorted() == actualValues.sorted(),
            )
        }
    }

    /**
     * Test sum the lists of list of ints
     *
     */
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

    /**
     * Test filter and sum based on even count
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount`() {
        val numbersList = listOf(10, 15, 20, 25, 30, 35) // Even numbers: 10, 20, 30
        val expected = 60 // (10 + 20 + 30)

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbersList)

        assertEquals(expected, result)
    }

    /**
     * Test filter and sum based on even count with no even numbers
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with no even numbers`() {
        val numbersList = listOf(1, 3, 5, 7, 9)
        val expected = 0 // No even numbers, so sum should be 0

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbersList)

        assertEquals(expected, result)
    }

    /**
     * Test filter and sum based on even count with mixed even and odd numbers
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with mixed even and odd numbers`() {
        val numbers = listOf(10, 15, 20, 25, 30, 35)

        val expected = 60 // (10 + 20 + 30)

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test filter and sum based on even count with only even numbers
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with only even numbers`() {
        val numbers = listOf(2, 4, 6, 8, 10)

        val expected = 30 // (2 + 4 + 6 + 8 + 10)

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test filter and sum based on even count with only odd numbers
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with only odd numbers`() {
        val numbers = listOf(1, 3, 5, 7, 9)

        val expected = 0 // No even numbers to sum

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test filter and sum based on even count with negative numbers
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with negative numbers`() {
        val numbers = listOf(-10, -15, -20, -25, -30)

        val expected = -60 // (-10 + -20 + -30)

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbers)

        assertEquals(expected, result)
    }

    /**
     * Test filter and sum based on even count with zero included
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with zero included`() {
        val numbers = listOf(0, 2, 4, 6, 8)

        val expected = 20 // (0 + 2 + 4 + 6 + 8)

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbers)

        assertEquals(expected, result)
    }


    /**
     * Test filter and sum based on even count with empty list
     *
     */
    @Test
    fun `test filterAndSumBasedOnEvenCount with empty list`() {
        val numbersList = emptyList<Int>()
        val expected = 0 // No numbers to sum

        val result = collectionsAdvanced.filterAndSumBasedOnEvenCount(numbersList)

        assertEquals(expected, result)
    }

    /**
     * Test sum the lists of list of ints with empty lists
     *
     */
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

    /**
     * Test string parsing into list then map
     *
     */
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

    /**
     * Test string parsing into list then map with empty input
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with empty input`() {
        val rawData = ""
        val expected = emptyMap<String, Int>() // Expect an empty map

        val result = collectionsAdvanced.stringParsingIntoListThenMap(rawData)

        assertEquals(expected, result)
    }

    /**
     * Test string parsing into list then map with spaces in input
     *
     */
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

    /**
     * Test string parsing into list then map with malformed input
     *
     */
    @Test
    fun `test stringParsingIntoListThenMap with malformed input`() {
        val rawData = "Alice:30,Bob:,Charlie:NaN"

        assertThrows(NumberFormatException::class.java) {
            collectionsAdvanced.stringParsingIntoListThenMap(rawData)
        }
    }

    /**
     * Test separate items by available flag into lists
     *
     */
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

    /**
     * Test separate items by available flag into lists with all available items
     *
     */
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

    /**
     * Test separate items by available flag into lists with all unavailable items
     *
     */
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

    /**
     * Test separate items by available flag into lists with empty list
     *
     */
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

    /**
     * Test get items available in all stores
     *
     */
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

    /**
     * Test get items available in all stores with overlapping available items
     *
     */
    @Test
    fun `test getItemsAvailableInAllStores with overlapping available items`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)
        val item3 = Item(3, true)
        val item4 = Item(4, false) // Unavailable item

        val store1 = Store(1, listOf(item1, item2, item3))
        val store2 = Store(2, listOf(item1, item2, item4)) // Only item1 and item2 overlap
        val store3 = Store(3, listOf(item1, item2)) // Only item1 and item2 remain consistent

        val stores = listOf(store1, store2, store3)

        val expected = setOf(item1, item2) // Items available in all stores

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test get items available in all stores with only one store
     *
     */
    @Test
    fun `test getItemsAvailableInAllStores with only one store`() {
        val store = Store(1, listOf(Item(1, true), Item(2, true), Item(3, true)))

        val stores = listOf(store)

        val expected =
            setOf(Item(1, true), Item(2, true), Item(3, true)) // All items from the single store

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test get items available in all stores with empty store list
     *
     */
    @Test
    fun `test getItemsAvailableInAllStores with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptySet<Item>() // No stores to check

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }


    /**
     * Test get items available in all stores with no common available items
     *
     */
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

    /**
     * Test get items available in all stores with identical available items in all stores
     *
     */
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

    /**
     * Test get items available in all stores with empty stores
     *
     */
    @Test
    fun `test getItemsAvailableInAllStores with empty stores`() {
        val stores = emptyList<Store>()

        val expected = emptySet<Item>() // No stores mean no items

        val result = collectionsAdvanced.getItemsAvailableInAllStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test map items to stores as available count
     *
     */
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

    /**
     * Test map items to stores as available count with no available items
     *
     */
    @Test
    fun `test mapItemsToStoresAsAvailableCount with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptyMap<Item, Int>() // No available items

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    /**
     * Test map items to stores as available count with empty store list
     *
     */
    @Test
    fun `test mapItemsToStoresAsAvailableCount with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptyMap<Item, Int>() // No stores mean no items

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    /**
     * Test map items to stores as available count with multiple stores and overlapping items
     *
     */
    @Test
    fun `test mapItemsToStoresAsAvailableCount with multiple stores and overlapping items`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)
        val item3 = Item(3, true)

        val store1 = Store(1, listOf(item1, item2))
        val store2 = Store(2, listOf(item1, item3))
        val store3 = Store(3, listOf(item1, item2, item3))

        val stores = listOf(store1, store2, store3)

        val expected = mapOf(
            item1 to 3, // Item 1 appears in 3 stores
            item2 to 2, // Item 2 appears in 2 stores
            item3 to 2  // Item 3 appears in 2 stores
        )

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    /**
     * Test map items to stores as available count with only one store
     *
     */
    @Test
    fun `test mapItemsToStoresAsAvailableCount with only one store`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)

        val store = Store(1, listOf(item1, item2))

        val stores = listOf(store)

        val expected = mapOf(
            item1 to 1, // Appears in 1 store
            item2 to 1  // Appears in 1 store
        )

        val result = collectionsAdvanced.mapItemsToStoresAsAvailableCount(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the most available items in stores with multiple stores and repeated items
     *
     */
    @Test
    fun `test findTheMostAvailableItemsInStores with multiple stores and repeated items`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)
        val item3 = Item(3, true)
        val item4 = Item(4, true)

        val store1 = Store(1, listOf(item1, item2, item3))
        val store2 = Store(2, listOf(item1, item2, item4)) // Item 1 and 2 appear again
        val store3 = Store(3, listOf(item1, item2, item4)) // Item 1 and 2 appear again

        val stores = listOf(store1, store2, store3)

        val expected = listOf(item1, item2) // Items 1 and 2 appear in the most stores (3 times)

        val result = collectionsAdvanced.findTheMostAvailableItemsInStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the most available items in stores with no available items
     *
     */
    @Test
    fun `test findTheMostAvailableItemsInStores with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptyList<Item>() // No available items in any store

        val result = collectionsAdvanced.findTheMostAvailableItemsInStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the most available items in stores with only one store
     *
     */
    @Test
    fun `test findTheMostAvailableItemsInStores with only one store`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)

        val store = Store(1, listOf(item1, item2))

        val stores = listOf(store)

        val expected = listOf(item1, item2) // Both items are the most available (appear once)

        val result = collectionsAdvanced.findTheMostAvailableItemsInStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the most available items in stores with empty store list
     *
     */
    @Test
    fun `test findTheMostAvailableItemsInStores with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptyList<Item>() // No stores to check

        val result = collectionsAdvanced.findTheMostAvailableItemsInStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the most available items in stores with equally available items
     *
     */
    @Test
    fun `test findTheMostAvailableItemsInStores with equally available items`() {
        val item1 = Item(1, true)
        val item2 = Item(2, true)
        val item3 = Item(3, true)

        val store1 = Store(1, listOf(item1, item2))
        val store2 = Store(2, listOf(item1, item3))
        val store3 = Store(3, listOf(item2, item3))

        val stores = listOf(store1, store2, store3)

        val expected = listOf(item1, item2, item3) // All appear twice, so all are "most available"

        val result = collectionsAdvanced.findTheMostAvailableItemsInStores(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items with multiple stores and different available counts
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems with multiple stores and different available counts`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, false), Item(3, true))) // 2 available
        val store2 = Store(2, listOf(Item(4, true), Item(5, true), Item(6, true))) // 3 available
        val store3 = Store(3, listOf(Item(7, true), Item(8, false))) // 1 available

        val stores = listOf(store1, store2, store3)

        val expected = listOf(store2) // Store 2 has the most available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items with tied stores
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems with tied stores`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, true))) // 2 available
        val store2 = Store(2, listOf(Item(3, true), Item(4, true))) // 2 available
        val store3 = Store(3, listOf(Item(5, true))) // 1 available

        val stores = listOf(store1, store2, store3)

        val expected = listOf(store1, store2) // Both store1 and store2 have 2 available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items with no available items
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptyList<Store>() // No stores have available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items with only one store
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems with only one store`() {
        val store = Store(1, listOf(Item(1, true), Item(2, true)))

        val stores = listOf(store)

        val expected = listOf(store) // The only store should be the result

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items with empty store list
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptyList<Store>() // No stores to check

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems(stores)

        assertEquals(expected, result)
    }


    /**
     * Test find the store with the most available items2
     *
     */
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

    /**
     * Test find the store with the most available items2 with multiple max stores
     *
     */
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

    /**
     * Test find the store with the most available items2 with no available items
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptyList<Store>() // No stores have available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items2 with empty store list
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptyList<Store>() // No stores available

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    /**
     * Test group words by length from a sentence
     *
     */
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

    /**
     * Test calculate word frequency in a sentence with normal sentence
     *
     */
    @Test
    fun `test calculateWordFrequencyInASentence with normal sentence`() {
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

    /**
     * Test calculate word frequency in a sentence with only punctuation
     *
     */
    @Test
    fun `test calculateWordFrequencyInASentence with only punctuation`() {
        val sentence = "!!! ... ,,, ???"

        val expected = emptyMap<String, Int>() // No actual words

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(
            sentence.replace(Regex("[^\\w']"), "") // Remove punctuation
        )

        assertEquals(expected, result)
    }


    /**
     * Test group words by length from a sentence with extra spaces
     *
     */
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

    /**
     * Test group words by length from a sentence with empty string
     *
     */
    @Test
    fun `test groupWordsByLengthFromASentence with empty string`() {
        val sentence = ""

        val expected = emptyMap<Int, List<String>>() // No words in sentence

        val result = collectionsAdvanced.groupWordsByLengthFromASentence(sentence)

        assertEquals(expected, result)
    }

    /**
     * Test calculate word frequency in a sentence
     *
     */
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

    /**
     * Test calculate word frequency in a sentence with punctuation
     *
     */
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

    /**
     * Test calculate word frequency in a sentence with case insensitivity
     *
     */
    @Test
    fun `test calculateWordFrequencyInASentence with case insensitivity`() {
        val sentence = "Kotlin kotlin Kotlin"

        val expected = mapOf(
            "kotlin" to 3
        )

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(sentence.lowercase())

        assertEquals(expected, result)
    }

    /**
     * Test calculate word frequency in a sentence with extra spaces
     *
     */
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

    /**
     * Test calculate word frequency in a sentence with empty string
     *
     */
    @Test
    fun `test calculateWordFrequencyInASentence with empty string`() {
        val sentence = ""

        val expected = emptyMap<String, Int>() // No words in sentence

        val result = collectionsAdvanced.calculateWordFrequencyInASentence(sentence)

        assertEquals(expected, result)
    }

    /**
     * Test get pair of lists splitting available and unavailable items
     *
     */
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

    /**
     * Test get pair of lists splitting available and unavailable items with mixed availability
     *
     */
    @Test
    fun `test getPairOfListsSplittingAvailableAndUnavailableItems with mixed availability`() {
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

    /**
     * Test get stores with more items available than not with mixed availability
     *
     */
    @Test
    fun `test getStoresWithMoreItemsAvailableThanNot with mixed availability`() {
        val store1 = Store(
            1,
            listOf(Item(1, true), Item(2, false), Item(3, true))
        ) // 2 available, 1 unavailable
        val store2 = Store(2, listOf(Item(4, false), Item(5, false))) // 0 available, 2 unavailable
        val store3 = Store(
            3,
            listOf(Item(6, true), Item(7, true), Item(8, false))
        ) // 2 available, 1 unavailable

        val stores = listOf(store1, store2, store3)

        val expected =
            setOf(store1, store3) // Stores 1 and 3 have more available than unavailable items

        val result = collectionsAdvanced.getStoresWithMoreItemsAvailableThanNot(stores)

        assertEquals(expected, result)
    }

    /**
     * Test get stores with more items available than not with no available items
     *
     */
    @Test
    fun `test getStoresWithMoreItemsAvailableThanNot with no available items`() {
        val store1 = Store(1, listOf(Item(1, false), Item(2, false)))
        val store2 = Store(2, listOf(Item(3, false), Item(4, false)))

        val stores = listOf(store1, store2)

        val expected = emptySet<Store>() // No stores have more available items

        val result = collectionsAdvanced.getStoresWithMoreItemsAvailableThanNot(stores)

        assertEquals(expected, result)
    }

    /**
     * Test get stores with more items available than not with all stores qualifying
     *
     */
    @Test
    fun `test getStoresWithMoreItemsAvailableThanNot with all stores qualifying`() {
        val store1 = Store(
            1,
            listOf(Item(1, true), Item(2, true), Item(3, false))
        ) // 2 available, 1 unavailable
        val store2 = Store(
            2,
            listOf(Item(4, true), Item(5, true), Item(6, false))
        ) // 2 available, 1 unavailable

        val stores = listOf(store1, store2)

        val expected =
            setOf(store1, store2) // Both stores have more available than unavailable items

        val result = collectionsAdvanced.getStoresWithMoreItemsAvailableThanNot(stores)

        assertEquals(expected, result)
    }

    /**
     * Test get stores with more items available than not with empty store list
     *
     */
    @Test
    fun `test getStoresWithMoreItemsAvailableThanNot with empty store list`() {
        val stores = emptyList<Store>()

        val expected = emptySet<Store>() // No stores to check

        val result = collectionsAdvanced.getStoresWithMoreItemsAvailableThanNot(stores)

        assertEquals(expected, result)
    }

    /**
     * Test separate items by available flag into lists with mixed availability
     *
     */
    @Test
    fun `test separateItemsByAvailableFlagIntoLists with mixed availability`() {
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

    /**
     * Test separate items by available flag into lists with no available items
     *
     */
    @Test
    fun `test separateItemsByAvailableFlagIntoLists with no available items`() {
        val items = listOf(
            Item(1, false),
            Item(2, false),
            Item(3, false)
        )

        val expectedAvailable = emptyList<Item>()
        val expectedUnavailable = listOf(Item(1, false), Item(2, false), Item(3, false))

        val (available, unavailable) = collectionsAdvanced.separateItemsByAvailableFlagIntoLists(
            items
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    /**
     * Test separate items by available flag into lists with no unavailable items
     *
     */
    @Test
    fun `test separateItemsByAvailableFlagIntoLists with no unavailable items`() {
        val items = listOf(
            Item(1, true),
            Item(2, true),
            Item(3, true)
        )

        val expectedAvailable = listOf(Item(1, true), Item(2, true), Item(3, true))
        val expectedUnavailable = emptyList<Item>()

        val (available, unavailable) = collectionsAdvanced.separateItemsByAvailableFlagIntoLists(
            items
        )

        assertEquals(expectedAvailable, available)
        assertEquals(expectedUnavailable, unavailable)
    }

    /**
     * Test get stores with more items available than not with equal available and unavailable items
     *
     */
    @Test
    fun `test getStoresWithMoreItemsAvailableThanNot with equal available and unavailable items`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, false))) // 1 available, 1 unavailable
        val store2 = Store(2, listOf(Item(3, false), Item(4, true))) // 1 available, 1 unavailable

        val stores = listOf(store1, store2)

        val expected = emptySet<Store>() // No store has more available than unavailable items

        val result = collectionsAdvanced.getStoresWithMoreItemsAvailableThanNot(stores)

        assertEquals(expected, result)
    }


    /**
     * Test get pair of lists splitting available and unavailable items with no available items
     *
     */
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

    /**
     * Test get pair of lists splitting available and unavailable items with no unavailable items
     *
     */
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

    /**
     * Test get pair of lists splitting available and unavailable items with empty store list
     *
     */
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

    /**
     * Test find the store with the most available items2 with tied stores
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with tied stores`() {
        val store1 = Store(1, listOf(Item(1, true), Item(2, true))) // 2 available
        val store2 = Store(2, listOf(Item(3, true), Item(4, true))) // 2 available
        val store3 = Store(3, listOf(Item(5, true))) // 1 available

        val stores = listOf(store1, store2, store3)

        val expected = listOf(store1, store2) // Both store1 and store2 have 2 available items

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }

    /**
     * Test find the store with the most available items2 with only one store
     *
     */
    @Test
    fun `test findTheStoreWithTheMostAvailableItems2 with only one store`() {
        val store = Store(1, listOf(Item(1, true), Item(2, true)))

        val stores = listOf(store)

        val expected = listOf(store) // The only store should be the result

        val result = collectionsAdvanced.findTheStoreWithTheMostAvailableItems2(stores)

        assertEquals(expected, result)
    }
}
