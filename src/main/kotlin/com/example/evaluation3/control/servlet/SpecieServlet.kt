package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.servlet.base.CrudServlet
import com.example.evaluation3.control.transform.SpecieTransform
import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.dao.SpecieDao
import com.example.evaluation3.data.dao.base.Dao
import com.example.evaluation3.data.model.entities.Specie
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "specie", value = ["/specie"])
class SpecieServlet : CrudServlet<Specie>() {
    override val transform: Transform<Specie> = SpecieTransform()
    override val dao: Dao<Specie>
        get() = SpecieDao

    override val path = "species"
}