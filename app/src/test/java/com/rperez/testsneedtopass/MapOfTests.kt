package com.rperez.testsneedtopass

import com.rperez.testsneedtopass.prac.Constants.Companion
import org.junit.Test

class MapOfTests {

    @Test
    fun initMapOfKeyTest() {
        var actual = Companion.intStringMap
        var oneInt = 1
        assert(actual.keys.contains(oneInt))
    }

    @Test
    fun initMapOfValueTest() {
        var actual = Companion.intStringMap
        var oneString = "one"
        assert(actual.values.contains(oneString))
    }
}