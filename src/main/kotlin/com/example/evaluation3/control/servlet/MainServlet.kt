package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.servlet.base.BaseServlet
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "main", value = ["/main"])
class MainServlet : BaseServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {

    }

    override fun destroy() {
    }
}