package ru.depo.api.crash.type

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "crashtype", schema = "public")
class CrashType(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "typeid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String,

        @Column(name = "description")
        val description: String,

        @Column(name = "cost")
        val cost: BigDecimal
)