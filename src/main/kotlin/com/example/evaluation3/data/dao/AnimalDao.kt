package com.example.evaluation3.data.dao

import com.example.evaluation3.data.dao.base.BaseDao
import com.example.evaluation3.data.model.Animal

object AnimalDao : BaseDao<Animal>() {
    override fun getEntityClass() = Animal::class.java
}