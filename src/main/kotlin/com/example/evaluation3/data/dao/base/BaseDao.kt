package com.example.evaluation3.data.dao.base

import com.example.evaluation3.data.config.DbConfig
import com.example.evaluation3.data.model.base.BaseEntity
import jakarta.persistence.criteria.CriteriaQuery
import org.hibernate.Session
import org.hibernate.query.Query


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
        return session.createQueryAndCloseSession(criteria).resultList
    }

    override fun update(entity: E) {
        createTransaction {
            update(entity)
        }
    }

    override fun delete(entity: E) {
        createTransaction {
            delete(entity)
        }
    }

    // doc ref https://kotlinlang.org/docs/extensions.html
    protected fun createTransaction(action: Session.() -> Unit) {
        with(session) {
            beginTransaction()
            action()
            transaction.commit()
            close()
        }
    }

    protected fun Session.createQueryAndCloseSession(criteria: CriteriaQuery<E>): Query<E> {
        val query = createQuery(criteria)
        close()
        return query
    }
}