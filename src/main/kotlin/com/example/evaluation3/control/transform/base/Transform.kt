package com.example.evaluation3.control.transform.base

import jakarta.servlet.http.HttpServletRequest

interface Transform<E> {
    fun fromRequest(request: HttpServletRequest): E
}