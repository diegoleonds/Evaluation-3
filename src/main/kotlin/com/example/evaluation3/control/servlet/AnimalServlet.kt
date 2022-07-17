package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.servlet.base.CrudServlet
import com.example.evaluation3.control.transform.AnimalTransform
import com.example.evaluation3.data.dao.AnimalDao
import com.example.evaluation3.data.dao.SubSpecieDao
import com.example.evaluation3.data.model.entities.Animal
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "animal", value = ["/animal"])
class AnimalServlet: CrudServlet<Animal>() {
    companion object {
        const val subspecies = "subspecies"
    }
    override val transform = AnimalTransform()
    override val dao = AnimalDao
    override val path = "animal"

    override fun handleGetRegisterRequest(request: HttpServletRequest, response: HttpServletResponse) {
        request.setAttribute(subspecies, SubSpecieDao.getEntities())
    }

    override fun handlePostGoToEditRequest(request: HttpServletRequest, response: HttpServletResponse) {
        request.setAttribute(subspecies, SubSpecieDao.getEntities())
    }
}