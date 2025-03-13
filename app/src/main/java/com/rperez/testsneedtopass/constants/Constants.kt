package com.rperez.testsneedtopass.constants

/**
 * Constants
 *
 * @constructor Create empty Constants
 */
class Constants {


    /**
     * Companion
     *
     * @constructor Create empty Companion
     */
    companion object {

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
         * Numbers list
         */
        val numbersListOddEven = listOf(10, 15, 20, 25, 30, 35)


        /**
         * Sentence
         */
        val sentence = "Kotlin is a great programming language"


        /**
         * Raw data
         */
        val rawData = "Alice:30,Bob:25,Charlie:30,David:40,Eve:25"

        /**
         * Nested list
         */
        val nestedList = listOf(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)
        )

        /**
         * Numbers map
         */
        val numbersMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")


        /**
         * Salaries
         */
        val salaries = mapOf("John" to 5000, "Jane" to 6000, "Jack" to 5500)


        /**
         * Names map
         */
        val namesMap = mapOf(1 to "alice", 2 to "bob", 3 to "charlie")

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
         * Numbers occurrences
         */
        val numbersOccurrences = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)

        /**
         * Words
         */
        val words = listOf("apple", "banana", "apple", "orange", "banana", "banana")

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
         * String name
         */
        var stringName = "Richard"

        /**
         * Numbers list
         */
        var numbersList = listOf<Int>(1, 2, 3, 1, 5, 10, 1, 2)

        /**
         * Names
         */
        var names = listOf<String>("Richard", "Ginger Ale", "7-Up", "Rick")

        /**
         * Names duplicates
         */
        var namesDuplicates =
            listOf<String>("Rick", "Richard", "Ginger Ale", "7-Up", "Rick", "Richard")

        /**
         * Numbers
         */
        var numbers = listOf<Int>(1, 3, 55, 100, 34)

        /**
         * Int string map
         */
        var intStringMap = mapOf<Int, String>(
            1 to "one",
            3 to "three",
            55 to "fifty-five",
            100 to "one hundred",
            34 to "thirty-four"
        )
    }
}