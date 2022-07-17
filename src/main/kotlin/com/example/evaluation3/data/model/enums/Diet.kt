package com.example.evaluation3.data.model.enums

enum class Diet(
    val description: String
) {
    HERBIVORE("herbivore"),
    CARNIVORE("carnivore"),
    OMNIVORE("omnivore");

    companion object : EnumHandler<Diet> {
        override fun findByName(name: String) = values().find { it.name == name } ?: throw getEnumNotFoundException(name)
    }
}
