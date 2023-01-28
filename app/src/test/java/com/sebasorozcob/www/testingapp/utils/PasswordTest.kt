package com.sebasorozcob.www.testingapp.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class PasswordTest {

    lateinit var utils: Utils

    @Before
    fun setUp() {
        utils = Utils()
    }

    @Test
    fun `password should not be empty`() {
        val result = utils.validatePassword(" ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun `password should be greater than 6`() {
        val result = utils.validatePassword("S9128")
        assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun `password should be less than 15`() {
        val result = utils.validatePassword("S9128awidnioanwdoanwiondioaiwnd")
        assertEquals("Length of the password should be less than 15", result)
    }

    @Test
    fun `password should be valid`() {
        val result = utils.validatePassword("123456789")
        assertEquals("Valid", result)
    }
}