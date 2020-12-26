package ru.depo.api.detailtype

import javax.persistence.*

@Entity
@Table(name = "detailtype", schema = "depo")
class DetailType(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "detailtypeid")
        val id: Long? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "number")
        val number: Long? = null
)