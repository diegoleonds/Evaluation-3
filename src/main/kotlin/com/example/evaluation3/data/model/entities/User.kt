package com.example.evaluation3.data.model.entities

import com.example.evaluation3.data.model.base.BaseEntity
import com.example.evaluation3.data.model.enums.AccessLevel
import jakarta.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "name", nullable = false)
    val password: String,

    @Column(name = "access_level", nullable = false)
    val accessLevel: AccessLevel
): BaseEntity()