package com.example.evaluation3.control.servlet.base

import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.dao.base.Dao
import com.example.evaluation3.data.model.base.BaseEntity
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

abstract class CrudServlet<E: BaseEntity> : BaseServlet() {
    companion object {
        const val register = "register"
        const val list = "list"
        const val edit = "edit"
        const val goToEdit = "goToEdit"
        const val delete = "delete"
    }

    abstract val transform: Transform<E>
    abstract val dao: Dao<E>
    abstract val path: String

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(register)) {
            handleGetRegisterRequest(request, response)
            servletContext.getRequestDispatcher("/$path/register.jsp").forward(request, response)
        } else if (request.hasParameter(list)) {
            request.setAttribute("entities", dao.getEntities())
            servletContext.getRequestDispatcher("/$path/list.jsp").forward(request, response)
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
            handlePostGoToEditRequest(request, response)
            request.getParameter("id")?.let {
                request.setAttribute("entity", dao.getBydId(it.toLong()))
                servletContext.getRequestDispatcher("/$path/edit.jsp").forward(request, response)
            }
        } else if (request.hasParameter(edit)) {
            dao.update(transform.fromRequest(request))
        }
    }

    protected open fun handleGetRegisterRequest(request: HttpServletRequest, response: HttpServletResponse) {
    }

    protected open fun handlePostGoToEditRequest(request: HttpServletRequest, response: HttpServletResponse) {
    }
}