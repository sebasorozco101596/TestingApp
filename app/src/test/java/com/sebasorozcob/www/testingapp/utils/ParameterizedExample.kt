package com.sebasorozcob.www.testingapp.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(private val input: String, private val expectedResult: Boolean) {

    @Test
    fun test() {
        val utils = Utils()
        val result = utils.isPallindrome(input)
        assertEquals(expectedResult, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} is pallindrome? - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("anilina", true),
                arrayOf("", false),
                arrayOf("o", true),
                arrayOf(" ",true)
            )
        }
    }
}