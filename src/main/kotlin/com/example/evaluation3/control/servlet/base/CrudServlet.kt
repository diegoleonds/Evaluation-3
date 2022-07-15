package com.example.evaluation3.control.servlet.base

import com.example.evaluation3.control.transform.base.Transform
import com.example.evaluation3.data.dao.base.Dao
import com.example.evaluation3.data.model.base.BaseEntity

abstract class CrudServlet<E: BaseEntity> : BaseServlet() {
    protected open val register = "register"
    protected open val view = "view"
    protected open val edit = "edit"
    protected open val goToEdit = "goToEdit"
    protected open val delete = "delete"
    protected open val list = "list"

    abstract val transform: Transform<E>
    abstract val dao: Dao<E>
}