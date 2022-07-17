package com.example.evaluation3.data.dao

import com.example.evaluation3.data.dao.base.BaseDao
import com.example.evaluation3.data.model.entities.User

object UserDao : BaseDao<User>() {
    override fun getEntityClass() = User::class.java

    fun getUser(username: String, password: String): User? {
        return try {
            session.createQuery(
                "SELECT u FROM ${getEntityClass().simpleName} u WHERE u.username = :username " +
                        "AND u.password = :password", getEntityClass())
                .setParameter("username", username)
                .setParameter("password", password).singleResult
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

//fun main() {
//    UserDao.insert(User(
//        username = "admin",
//        password = "gremio10".toSha256(),
//        accessLevel = AccessLevel.ADMIN
//    ))
//    UserDao.insert(User(
//        username = "user",
//        password = "gremio10".toSha256(),
//        accessLevel = AccessLevel.USER
//    ))
//}