package ru.depo.api.manager

import javax.persistence.*

@Entity
@Table(name = "manager", schema = "depo")
class Manager(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "managerid")
        val id: Long? = null,

        @Column(name = "fio")
        val fio: String,

        @Column(name = "phonenumber")
        val phone: Long,
)