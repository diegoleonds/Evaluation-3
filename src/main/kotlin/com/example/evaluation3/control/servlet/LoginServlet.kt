package com.example.evaluation3.control.servlet

import com.example.evaluation3.control.auth.toSha256
import com.example.evaluation3.control.servlet.base.BaseServlet
import com.example.evaluation3.data.dao.UserDao
import com.example.evaluation3.data.model.entities.User
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "login", value = ["/login"])
class LoginServlet : BaseServlet() {
    companion object {
        const val login = "login"
        const val username = "username"
        const val password = "password"
    }

    override fun doGet(request: HttpServletRequest?, response: HttpServletResponse?) {
        servletContext.getRequestDispatcher("/login.jsp").forward(request, response)
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.hasParameter(login)) {
            val usernameParam = request.getParameter(username)
            val passwordParam = request.getParameter(password)?.let { it.toSha256() }

            if (usernameParam != null && passwordParam != null) {
                val user = UserDao.getUser(usernameParam, passwordParam)

                if (user != null) {
                    response.saveLoginCookie(user)
                    servletContext.getRequestDispatcher("/menu.jsp").forward(request, response)
                } else {
                    servletContext.getRequestDispatcher("/login.jsp").forward(request, response)
                }
            }
        }
    }

    private fun HttpServletResponse.saveLoginCookie(user: User) {
        addCookie(Cookie(loginCookie, "${user.id}").apply { maxAge = 24 * 60 * 60 })
    }
}