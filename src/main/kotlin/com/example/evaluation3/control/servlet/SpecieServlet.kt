package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.base.CrudServlet
import com.example.evaluation3.data.dao.SpecieDao
import com.example.evaluation3.data.model.entities.Specie
import com.example.evaluation3.data.model.enums.Diet
import com.example.evaluation3.data.model.enums.Movement
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "specie", value = ["/specie"])
class SpecieServlet : CrudServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(registerParam)) {
            servletContext.getRequestDispatcher("/registerSpecie.jsp").forward(request, response)
        }
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(registerParam)) {

            println("Values:"+ request.getParameter("diet"))
            println(request.getParameterValues("movements"))

            val specie = Specie(
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
            SpecieDao.insert(specie)
        }
    }

    override fun destroy() {
    }
}