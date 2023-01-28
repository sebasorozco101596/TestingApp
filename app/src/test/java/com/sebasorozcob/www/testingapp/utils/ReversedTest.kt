package com.sebasorozcob.www.testingapp.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class ReversedTest {

    lateinit var util: Utils

    @Before
    fun setUp() {
        util = Utils()
    }

    @Test
    fun reverseString() {
        val result = util.reverseString("abc")
        assertEquals("cba", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `the input should not be null`() {
        val result = util.reverseString(null)
    }

}