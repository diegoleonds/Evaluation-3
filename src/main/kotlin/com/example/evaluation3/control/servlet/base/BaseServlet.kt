package com.example.evaluation3.control.servlet.base

import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest

abstract class BaseServlet : HttpServlet() {
    companion object {
        const val loginCookie = "loginCookie"
    }
    protected fun HttpServletRequest.hasParameter(parameter: String) = getParameter(parameter) != null
}