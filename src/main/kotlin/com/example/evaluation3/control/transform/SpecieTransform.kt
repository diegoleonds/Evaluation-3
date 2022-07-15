package com.example.evaluation3.control.transform

import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.model.entities.Specie
import com.example.evaluation3.data.model.enums.Diet
import com.example.evaluation3.data.model.enums.Movement
import jakarta.servlet.http.HttpServletRequest

class SpecieTransform : Transform<Specie> {

    override fun fromRequest(request: HttpServletRequest): Specie {
        return Specie(
            id = request.getParameter("id").toLong(),
            name = request.getParameter("name"),
            diet = Diet.findByName(request.getParameter("diet")),
            movements = request.getParameterValues("movements").let { parameters ->
                HashSet<Movement>().apply {
                    parameters.forEach { parameter ->
                        add(Movement.findByName(parameter))
                    }
                }
            }
        )
    }
}