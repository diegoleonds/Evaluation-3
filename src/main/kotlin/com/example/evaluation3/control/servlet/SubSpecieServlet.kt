package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.servlet.base.CrudServlet
import com.example.evaluation3.control.transform.SubSpecieTransform
import com.example.evaluation3.data.dao.SpecieDao
import com.example.evaluation3.data.dao.SubSpecieDao
import com.example.evaluation3.data.model.entities.SubSpecie
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "subspecies", value = ["/subspecies"])
class SubSpecieServlet : CrudServlet<SubSpecie>() {
    override val transform = SubSpecieTransform()
    override val dao = SubSpecieDao
    override val path = "subspecies"

    override fun handleGetRegisterRequest(request: HttpServletRequest, response: HttpServletResponse) {
        request.setAttribute("species", SpecieDao.getEntities())
    }

    override fun handlePostGoToEditRequest(request: HttpServletRequest, response: HttpServletResponse) {
        request.setAttribute("species", SpecieDao.getEntities())
    }
}