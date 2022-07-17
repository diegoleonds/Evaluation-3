package com.example.evaluation3.data.dao

import com.example.evaluation3.control.auth.toSha256
import com.example.evaluation3.data.model.entities.User
import com.example.evaluation3.data.model.enums.AccessLevel
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UserDaoTest {
    private val dao = UserDao
    private val user = User(
        username = "test",
        password = "gremio10".toSha256(),
        accessLevel = AccessLevel.ADMIN
    )

    @Before
    fun before() {
        dao.insert(user)
    }

    @Test
    fun `should return an user when username and password are correct`() {
        val userFromDb = dao.getUser(user.username, user.password)
        assertNotNull(userFromDb)
        assertEquals(user, userFromDb)
        println(userFromDb)
    }

    @Test
    fun `should not return an user when username and password are incorrect`() {
        val userFromDb = dao.getUser(user.username, "inter10")
        assertNotNull(userFromDb)
        assertNotEquals(user, userFromDb)
        println(userFromDb)
    }

    @After
    fun after() {
        if (dao.getBydId(user.id) != null) {
            dao.delete(user)
        }
    }
}