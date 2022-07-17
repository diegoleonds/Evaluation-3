package com.example.evaluation3.data.model.enums

interface EnumHandler<E> {
    fun findByName(name: String): E
    fun getEnumNotFoundException(name: String) = Exception("Enum with name $name not found")
}