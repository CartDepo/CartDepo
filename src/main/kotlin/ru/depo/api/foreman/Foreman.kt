package ru.depo.api.foreman

import javax.persistence.*

@Entity
@Table(name = "foreman", schema = "public")
class Foreman(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "foremanid")
        val id: Long? = null,

        @Column(name = "fio")
        val fio: String,

        @Column(name = "phonenumber")
        val phone: String,
)