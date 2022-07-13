package com.example.evaluation3.data.model

import com.example.evaluation3.data.model.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "specie")
class Specie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "diet", nullable = false)
    val diet: Diet,

    @Column
    @Enumerated
    @ElementCollection
    val movements: Set<Movement> = emptySet(),
) : BaseEntity()