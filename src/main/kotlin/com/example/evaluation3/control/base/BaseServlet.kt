package com.example.evaluation3.control.base

import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest

abstract class BaseServlet : HttpServlet() {

    protected fun HttpServletRequest.hasParameter(parameter: String) = getParameter(parameter) != null
}