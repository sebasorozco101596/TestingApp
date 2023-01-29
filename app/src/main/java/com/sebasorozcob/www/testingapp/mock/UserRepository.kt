package com.sebasorozcob.www.testingapp.mock

class UserRepository {

    val users = listOf<User>(
        User(1, "Juan","juan@gmail.com","12aidjkl"),
        User(2, "Sebastian","sebastian@gmail.com","212aidjkl"),
        User(3, "Clarena","clare@gmail.com","12aiadjkl"),
    )

    fun loginUser(email: String, password: String) : LOGIN_STATUS {

        // Fetch user from DB
        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        }
        else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}