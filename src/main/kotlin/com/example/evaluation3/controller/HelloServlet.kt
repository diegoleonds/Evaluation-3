package com.example.evaluation3.servlet

import com.example.evaluation3.data.dao.SpecieDao
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", value = ["/hello-servlet"])
class HelloServlet : HttpServlet() {

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"

        with(response.writer) {
            println("<html><body>")
            println("<h1>${test()}</h1>")
            println("</body></html>")
        }
    }

    private fun test(): String {
        return try {
            val monkey = SpecieDao.getBydId(1L)
            var string = ""

            string += monkey?.name + "\n"
            string += monkey?.diet?.description + "\n"
            string += monkey?.movements

            string

        } catch (e: java.lang.Exception) {
            e.toString()
        }
    }

    override fun destroy() {
    }
}