package com.rperez.testsneedtopass.prac

import com.rperez.testsneedtopass.prac.Constants.Companion.names
import com.rperez.testsneedtopass.prac.Constants.Companion.namesDuplicates

class FilterPrac {

    /**
     * Remove1rick
     *
     * @return
     */
    fun remove1Rick(): List<String> {
        return names - "Rick"
    }

    /**
     * Remove all rick
     *
     * @return
     */
    fun removeAllRick(): List<String> {
        return names.filter { it != "Rick" }
    }

    /**
     * Remove rs
     *
     * @return
     */
    fun removeRs(): List<String> {
        return names.filterNot { it.lowercase().contains("r") }
    }
}