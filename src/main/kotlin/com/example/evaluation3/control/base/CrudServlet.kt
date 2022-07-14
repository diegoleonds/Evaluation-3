package com.example.evaluation3.control.base

abstract class CrudServlet : BaseServlet() {
    protected open val registerParam = "register"
    protected open val viewParam = "view"
    protected open val updateParam = "update"
    protected open val deleteParam = "delete"
    protected open val listParam = "list"
}