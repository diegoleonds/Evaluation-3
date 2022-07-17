package com.example.evaluation3.control.transform

import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.dao.SpecieDao
import com.example.evaluation3.data.model.entities.SubSpecie
import jakarta.servlet.http.HttpServletRequest

class SubSpecieTransform : Transform<SubSpecie> {
    override fun fromRequest(request: HttpServletRequest): SubSpecie {
        return SubSpecie(
            id = request.getIdParameter(),
            name = request.getNameParameter(),
            specie = SpecieDao.getBydId(request.getParameter("specie_id")!!.toLong())
                ?: throw Exception("Specie for subspecie not found")
        )
    }
}