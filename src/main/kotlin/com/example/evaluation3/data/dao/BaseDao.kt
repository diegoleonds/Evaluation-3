package com.example.evaluation3.data.dao

import com.example.evaluation3.data.model.BaseEntity
import jakarta.persistence.Persistence
import java.util.*

abstract class BaseDao<E : BaseEntity> : Dao<E> {

    protected val manager by lazy {
        Persistence.createEntityManagerFactory("meuPU").createEntityManager()
    }

    abstract fun getEntityClass(): Class<E>

    protected fun getEntityTableName(): String {
        return getEntityClass().simpleName.replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.getDefault())
            else
                it.toString()
        }
    }

    override fun getBydId(id: Long): E? {
        TODO("Not yet implemented")
    }

    override fun getEntities(offset: Int, page: Int): List<E> {
        TODO("Not yet implemented")
    }

    override fun insert(entity: E) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: E) {
        TODO("Not yet implemented")
    }

    override fun update(entity: E) {
        TODO("Not yet implemented")
    }
}