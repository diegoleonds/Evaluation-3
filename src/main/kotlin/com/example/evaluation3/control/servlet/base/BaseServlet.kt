package com.example.evaluation3.control.servlet.base

import com.example.evaluation3.data.dao.UserDao
import com.example.evaluation3.data.model.entities.User
import com.example.evaluation3.data.model.enums.AccessLevel
import jakarta.servlet.ServletContext
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

abstract class BaseServlet : HttpServlet() {
    companion object {
        const val loginCookie = "loginCookie"
    }

    protected fun HttpServletRequest.hasParameter(parameter: String) = getParameter(parameter) != null

    protected fun HttpServletRequest.getCookie(cookieName: String) = cookies?.find { it.name == cookieName }
    protected fun HttpServletRequest.getLoginCookie() = getCookie(loginCookie)

    protected fun HttpServletRequest.verifyCookie(cookieName: String) = getCookie(cookieName) != null
    protected fun HttpServletRequest.verifyLoginCookie() = verifyCookie(loginCookie)

    protected fun HttpServletRequest.handleLoginCookie(
        onSuccess: (user: User) -> Unit,
        onFailure: (loginCookie: Cookie?) -> Unit
    ) {
        if (verifyLoginCookie()) {
            val cookieUserId = getLoginCookie()?.value?.toLong()
            if (cookieUserId != null) {
                val user = UserDao.getBydId(cookieUserId)
                if (user != null) {
                    onSuccess(user)
                } else {
                    onFailure(getLoginCookie())
                }
            } else {
                onFailure(getLoginCookie())
            }
        } else {
            onFailure(getLoginCookie())
        }
    }

    protected fun ServletContext.redirectToLogin(request: HttpServletRequest, response: HttpServletResponse) {
        getRequestDispatcher("/login.jsp").forward(request, response)
    }

    protected fun ServletContext.redirectToMenu(request: HttpServletRequest, response: HttpServletResponse) {
        getRequestDispatcher("/menu.jsp").forward(request, response)
    }

    protected fun ServletContext.redirectToNotAuthorizedPage(request: HttpServletRequest, response: HttpServletResponse) {
        getRequestDispatcher("/not_authorized.jsp").forward(request, response)
    }

    protected fun checkAccessLevel(user: User, requiredAccessLevel: AccessLevel) =
        user.accessLevel == requiredAccessLevel
}