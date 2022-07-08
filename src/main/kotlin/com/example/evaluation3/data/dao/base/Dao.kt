package com.example.evaluation3.data.dao.base

import com.example.evaluation3.data.model.base.BaseEntity

interface Dao<E : BaseEntity> {
    fun insert(entity: E)
    fun getBydId(id: Long): E?
    fun getEntities(offset: Int, page: Int): List<E>
    fun update(entity: E)
    fun delete(entity: E)
}