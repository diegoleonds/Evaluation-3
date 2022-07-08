package com.example.evaluation3.data.dao

import com.example.evaluation3.data.dao.base.BaseDao
import com.example.evaluation3.data.model.Specie

object SpecieDao : BaseDao<Specie>() {
    override fun getEntityClass() = Specie::class.java
}