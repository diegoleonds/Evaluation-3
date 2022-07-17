package com.example.evaluation3.control.auth

import com.example.evaluation3.data.dao.UserDao
import com.example.evaluation3.data.model.entities.User

class Authenticator {
    fun verifyLogin(username: String?, password: String?, isSuccessful: (user: User) -> Unit,
                    isFailure: (username: String?) -> Unit) {
        if (username != null && password != null) {
            val user = UserDao.getUser(username, password.toSha256())
            if (user != null) {
                isSuccessful(user)
            } else {
                isFailure(username)
            }
        } else {
            isFailure(username)
        }
    }
}