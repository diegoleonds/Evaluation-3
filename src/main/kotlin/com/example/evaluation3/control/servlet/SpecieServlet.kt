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

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(register)) {
            servletContext.getRequestDispatcher("/registerSpecie.jsp").forward(request, response)
        } else if (request.hasParameter(list)) {
            request.setAttribute("entities", dao.getEntities())
            servletContext.getRequestDispatcher("/listSpecies.jsp").forward(request, response)
        }
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(register)) {
            dao.insert(transform.fromRequest(request))
        } else if (request.hasParameter(delete)) {
            request.getParameter("id")?.let {
                dao.deleteBydId(it.toLong())
            }
        } else if (request.hasParameter(goToEdit)) {
            request.getParameter("id")?.let {
                request.setAttribute("entity", dao.getBydId(it.toLong()))
                servletContext.getRequestDispatcher("/editSpecie.jsp").forward(request, response)
            }
        } else if (request.hasParameter(edit)) {
            dao.update(transform.fromRequest(request))
        }
    }

    override fun destroy() {
    }
}