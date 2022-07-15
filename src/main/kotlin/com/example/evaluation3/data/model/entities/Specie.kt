package com.example.evaluation3.data.model.entities

import com.example.evaluation3.data.model.base.BaseEntity
import com.example.evaluation3.data.model.enums.Diet
import com.example.evaluation3.data.model.enums.Movement
import jakarta.persistence.*

@Entity
@Table(name = "specie")
data class Specie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "diet", nullable = false)
    var diet: Diet,

    @Column
    @Enumerated
    @ElementCollection
    val movements: Set<Movement> = emptySet(),
) : BaseEntity()