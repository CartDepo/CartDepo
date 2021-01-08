package ru.depo.api.contract.status

import javax.persistence.*

@Entity
@Table(name = "contractstatus", schema = "public")
class ContractStatus(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "contractstatusid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String,
)