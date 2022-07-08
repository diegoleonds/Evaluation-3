package com.example.evaluation3.data.dao

import com.example.evaluation3.data.model.BaseEntity

interface Dao<E : BaseEntity> {
    fun insert(entity: E)
    fun getBydId(id: Long): E?
    fun getEntities(offset: Int, page: Int): List<E>
    fun update(entity: E)
    fun delete(entity: E)
}