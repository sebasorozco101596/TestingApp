package com.sebasorozcob.www.testingapp.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class UtilsTest {

    private lateinit var utils: Utils

    @Before
    fun setUp() {
        utils = Utils()
    }

    @Test
    fun isPallindrome() {
        // Act
        val result = utils.isPallindrome("hello")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun `when the pallindrome result is true`() {
        // Act
        val result = utils.isPallindrome("level")
        // Assert
        assertEquals(true, result)
    }

    @Test
    fun `when the pallindrome input is empty`() {
        // Act
        val result = utils.isPallindrome("")
        // Assert
        assertEquals(false, result)
    }
}