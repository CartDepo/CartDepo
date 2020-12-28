package ru.depo.api.crash.status

import javax.persistence.*

@Entity
@Table(name = "crashstatus", schema = "public")
class CrashStatus(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "crashstatusid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String
)