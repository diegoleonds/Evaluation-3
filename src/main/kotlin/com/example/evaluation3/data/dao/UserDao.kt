package com.example.evaluation3.data.dao

import com.example.evaluation3.data.dao.base.BaseDao
import com.example.evaluation3.data.model.entities.User

object UserDao: BaseDao<User>() {
    override fun getEntityClass() = User::class.java

    fun getUser(username: String, password: String): User? {
        TODO()
    }
}