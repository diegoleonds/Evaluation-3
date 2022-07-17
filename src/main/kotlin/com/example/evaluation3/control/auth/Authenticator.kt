package com.example.evaluation3.control.auth

import com.example.evaluation3.data.dao.UserDao

class Authenticator {
    fun isUserLoggedIn(username: String, password: String) = UserDao.getUser(username, password.toSha256()) != null
}