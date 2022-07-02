package com.example.evaluation3.data.dao

import com.example.evaluation3.data.model.BaseEntity
import jakarta.persistence.*
import java.util.*

abstract class BaseDao<E : BaseEntity> : Dao<E> {

    protected val manager: EntityManager by lazy {
        Persistence.createEntityManagerFactory("myDb").createEntityManager()
    }

    protected val transaction: EntityTransaction by lazy {
        manager.transaction
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

    override fun insert(entity: E) {
        createTransaction {
            manager.persist(entity)
        }
    }

    override fun getBydId(id: Long): E? {
        return manager.createQueryForEntityClass("FROM ${getEntityTableName()} where id = :id").run {
            setParameter("id", id)
            singleResult
        }
    }

    override fun getEntities(offset: Int, page: Int): List<E> {
        return manager.createQueryForEntityClass("FROM ${getEntityTableName()}").resultList ?: emptyList()
    }

    override fun update(entity: E) {

    }

    override fun delete(entity: E) {
        createTransaction {
            manager.remove(entity)
        }
    }

    protected fun createTransaction(action: () -> Unit) {
        transaction.begin()
        action()
        transaction.commit()
    }

    // doc ref https://kotlinlang.org/docs/extensions.html#extension-functions
    protected fun EntityManager.createQueryForEntityClass(query: String): TypedQuery<E> = createQuery(query, getEntityClass())
}