package com.example.evaluation3.data.dao

import org.junit.Assert.assertNotNull
import org.junit.Test

class SubSpecieDaoTest {
    val dao = SubSpecieDao

    @Test
    fun getAll() {
        val data = dao.getEntities()
        print(data)
        assertNotNull(data)
    }
}