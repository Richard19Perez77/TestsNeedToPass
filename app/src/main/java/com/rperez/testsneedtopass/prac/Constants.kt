package com.rperez.testsneedtopass.prac

class Constants {
    companion object {
        var names = listOf<String>("Richard", "Ginger Ale", "7-Up", "Rick")
        var numbers = listOf<Int>(1, 3, 55, 100, 34)
        var intStringMap = mapOf<Int, String>(
            1 to "one",
            3 to "three",
            55 to "fifty-five",
            100 to "one hundred",
            34 to "thirty-four"
        )
    }
}