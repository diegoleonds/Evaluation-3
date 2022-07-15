package com.example.evaluation3.data.dao.base

import com.example.evaluation3.data.config.DbConfig
import com.example.evaluation3.data.model.base.BaseEntity
import jakarta.persistence.criteria.CriteriaQuery
import org.hibernate.Session


abstract class BaseDao<E : BaseEntity> : Dao<E> {

    protected val session: Session by lazy {
        DbConfig.session
    }

    protected abstract fun getEntityClass(): Class<E>

    protected open fun getEntityTableName(): String = getEntityClass().simpleName.lowercase()

    override fun insert(entity: E) {
        createTransaction {
            save(entity)
        }
    }

    override fun getBydId(id: Long): E? = session.find(getEntityClass(), id)

    override fun getEntities(offset: Int, page: Int): List<E> {
        val builder = session.criteriaBuilder
        val criteria: CriteriaQuery<E> = builder.createQuery(getEntityClass())
        criteria.from(getEntityClass())
        return session.createQuery(criteria).resultList
    }

    override fun update(entity: E) {
        createTransaction {
            merge(entity)
        }
    }

    override fun delete(entity: E) {
        createTransaction {
            delete(entity)
        }
    }

    override fun deleteBydId(id: Long) {
        getBydId(id)?.let {
            delete(it)
        }
    }

    // doc ref https://kotlinlang.org/docs/extensions.html
    protected fun createTransaction(action: Session.() -> Unit) {
        with(session) {
            beginTransaction()
            action()
            transaction.commit()
        }
    }
}