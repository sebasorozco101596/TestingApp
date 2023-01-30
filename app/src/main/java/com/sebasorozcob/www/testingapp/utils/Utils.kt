package com.sebasorozcob.www.testingapp.utils

import kotlinx.coroutines.*

class Utils(private val dispatcher: CoroutineDispatcher?) {
    constructor() : this(null)

    fun isPallindrome(input: String) : Boolean {

        if (input.isEmpty()) {
            return false
        }

        var startPointer = 0
        var endPointer = input.length - 1
        var result = true

        while (startPointer < endPointer) {
            if (input[startPointer] != input[endPointer]) {
                result = false
                break
            }
            startPointer ++
            endPointer --
        }

        return result
    }

    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of the password should be greater than 6"
        }
        input.length > 15 -> {
            "Length of the password should be less than 15"
        }
        else -> {
            "Valid"
        }
    }

    fun reverseString(input: String?): String {

        if (input == null) {
            throw IllegalArgumentException("Input String is required")
        }

        var result = ""
        var pointer = input.length - 1

        while (pointer >= 0) {
            result += input[pointer]
            pointer --
        }

        return result
    }

    suspend fun getUserName(): String {
        delay(10000)
        return "Juan S Orozco Buitrago"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "User - Juan S Orozco Buitrago"
    }

    suspend fun getAddress(): String {
        CoroutineScope(dispatcher!!).launch {
            delay(5000)
        }
        return "Address"
    }

    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher!!).launch {
            globalArg = true
        }
    }

}