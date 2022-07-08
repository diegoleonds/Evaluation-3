package com.example.evaluation3.data.dao

import com.example.evaluation3.data.dao.base.BaseDao
import com.example.evaluation3.data.model.SubSpecie

object SubSpecieDao : BaseDao<SubSpecie>() {

    override fun getEntityTableName() = "sub_specie"

    override fun getEntityClass() = SubSpecie::class.java
}