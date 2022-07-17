package com.example.evaluation3.control.transform

import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.dao.SubSpecieDao
import com.example.evaluation3.data.model.entities.Animal
import jakarta.servlet.http.HttpServletRequest

class AnimalTransform : Transform<Animal> {
    override fun fromRequest(request: HttpServletRequest): Animal {
        return Animal(
            id = request.getIdParameter(),
            name = request.getNameParameter(),
            subSpecie = SubSpecieDao.getBydId(request.getParameter("sub_specie_id")!!.toLong())
                ?: throw Exception("Animal subspecie not found")
        )
    }
}