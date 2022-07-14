package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.servlet.base.CrudServlet
import com.example.evaluation3.control.transform.SpecieTransform
import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.dao.SpecieDao
import com.example.evaluation3.data.dao.base.BaseDao
import com.example.evaluation3.data.model.entities.Specie
import com.example.evaluation3.data.model.enums.Diet
import com.example.evaluation3.data.model.enums.Movement
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "specie", value = ["/specie"])
class SpecieServlet : CrudServlet<Specie>() {

    override val transform: Transform<Specie> = SpecieTransform()

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(registerParam)) {
            servletContext.getRequestDispatcher("/registerSpecie.jsp").forward(request, response)
        } else if (request.hasParameter(listParam)) {
            request.setAttribute("species", SpecieDao.getEntities())
            servletContext.getRequestDispatcher("/listSpecies.jsp").forward(request, response)
        }
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(registerParam)) {
            SpecieDao.insert(transform.fromRequest(request))
        }
    }

    override fun destroy() {
    }
}