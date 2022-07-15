package com.example.evaluation3.data.dao

import com.example.evaluation3.data.dao.base.Dao
import com.example.evaluation3.data.model.entities.Specie
import com.example.evaluation3.data.model.enums.Diet
import com.example.evaluation3.data.model.enums.Movement
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class SpecieDaoTest {
    private val duck = Specie(
        name = "Duck",
        diet = Diet.HERBIVORE,
        movements = setOf(Movement.FLY, Movement.SWIM, Movement.WALK)
    )

    private val dao: Dao<Specie>
        get() = SpecieDao

    @Before
    fun before() {
        if (dao.getBydId(duck.id) == null) {
            dao.insert(duck)
        }
    }

    @Test
    fun insert() {
        dao.insert(duck)
        assertEquals(duck, dao.getBydId(duck.id))
    }

    @Test
    fun selectById() {
        val duckFromDb = dao.getBydId(duck.id)
        assertEquals(duck.id, duckFromDb?.id ?: -1)
    }

    @Test
    fun update() {
        duck.name = "Duck 2"
        dao.update(duck)
        assertEquals(duck, dao.getBydId(duck.id))
    }

    @Test
    fun delete() {
        dao.delete(duck)
        assertNull(dao.getBydId(duck.id))
    }

    @After
    fun after() {
        if (dao.getBydId(duck.id) != null) {
            dao.delete(duck)
        }
    }
}