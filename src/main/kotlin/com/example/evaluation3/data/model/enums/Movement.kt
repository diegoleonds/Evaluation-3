package com.example.evaluation3.data.model.enums

enum class Movement(
    val description: String
) {
    FLY("fly"),
    WALK("walk"),
    SWIM("swim");

    companion object : EnumHandler<Movement> {
        override fun findByName(name: String) = values().find { it.name == name } ?: throw getEnumNotFoundException(name)
    }
}