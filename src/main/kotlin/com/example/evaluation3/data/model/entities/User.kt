package com.example.evaluation3.data.model.entities

import com.example.evaluation3.data.model.base.BaseEntity
import com.example.evaluation3.data.model.enums.AccessLevel
import jakarta.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "username", nullable = false)
    val username: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "access_level", nullable = false)
    val accessLevel: AccessLevel = AccessLevel.USER
): BaseEntity()