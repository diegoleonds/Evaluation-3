package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.base.BaseServlet
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "main", value = ["/main"])
class MainServlet : BaseServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter("registerSpecie")) {
            servletContext.getRequestDispatcher("/registerSpecie.jsp").forward(request, response)
        }
    }

    override fun destroy() {
    }
}