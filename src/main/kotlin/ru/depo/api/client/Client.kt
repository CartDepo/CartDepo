package ru.depo.api.client

import javax.persistence.*

@Entity
@Table(name = "client", schema = "public")
class Client(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clientid")
        val id: Long? = null,

        @Column(name = "fio")
        val fio: String,

        @Column(name = "pasportserial")
        val serial: String,

        @Column(name = "pasportnumber")
        val number: String,

        @Column(name = "phonenumber")
        val phone: String,
)