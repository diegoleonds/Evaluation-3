package com.example.evaluation3.data.model.enums

interface EnumHandler<E> {
    fun findByName(name: String): E
    fun getEnumNotFoundException() = Exception("Enum with this name not found")
}