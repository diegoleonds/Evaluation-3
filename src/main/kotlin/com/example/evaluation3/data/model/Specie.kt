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

    @ManyToMany(mappedBy = "")
    val movements: Set<Movement> = HashSet()
) : BaseEntity()