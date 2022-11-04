package com.example.demo.entities

import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "countries")
class Country (
        @field:Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @field:NotNull
        @field:Size(min=3, max =50)
        var nome: String,

        @field:NotNull
        @field:Size(min=3, max =50)
        var capital: String,

        @field:NotNull
        @field:Size(min=3, max =50)
        var regiao: String
)