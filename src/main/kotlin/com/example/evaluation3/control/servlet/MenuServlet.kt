package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.servlet.base.BaseServlet
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "menu", value = ["/menu"])
class MenuServlet : BaseServlet() {
    companion object {
        const val menu = "menu"
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
    }
}