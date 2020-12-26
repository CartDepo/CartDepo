package ru.depo.api.client

import javax.persistence.*

@Entity
@Table(name = "client", schema = "depo")
class Client(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clientid")
        val id: Long? = null,

        @Column(name = "fio")
        val fio: String,

        @Column(name = "pasportserial")
        val serial: Long,

        @Column(name = "pasportnumber")
        val number: Long,

        @Column(name = "phonenumber")
        val phone: Long,
)