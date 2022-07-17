package com.example.evaluation3.data.model.entities

import com.example.evaluation3.data.model.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "animal")
data class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name", nullable = false)
    val name: String,

    @ManyToOne
    val subSpecie: SubSpecie
) : BaseEntity()