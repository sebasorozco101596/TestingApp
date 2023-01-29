package com.sebasorozcob.www.testingapp.mock

import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).
                thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testUserService() {
        val sut = UserService(userRepository)
        val status = sut.loginUser("abc@gmail.com", "nnnnawaaaa")
        Assert.assertEquals("Password is invalid", status)
    }
}