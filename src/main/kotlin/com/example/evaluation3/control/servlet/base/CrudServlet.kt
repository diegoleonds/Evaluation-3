package com.example.evaluation3.control.servlet.base

import com.example.evaluation3.control.transform.base.Transform

abstract class CrudServlet<E> : BaseServlet() {
    protected open val registerParam = "register"
    protected open val viewParam = "view"
    protected open val updateParam = "update"
    protected open val deleteParam = "delete"
    protected open val listParam = "list"

    abstract val transform: Transform<E>
}