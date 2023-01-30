package com.sebasorozcob.www.testingapp.utils

import com.sebasorozcob.www.testingapp.Cprpitomes.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Rule
import org.junit.Test

class UserTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getAddressDetailTest() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddressDetail()
            // Help to let complete the coroutine process
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(true, sut.globalArg)
        }

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getUser() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUser()
        }

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getAddress() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddress()
        }

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getUserNameTest() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUserName()
        }

    }

}