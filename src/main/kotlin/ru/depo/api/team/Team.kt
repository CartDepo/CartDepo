package ru.depo.api.team

import ru.depo.api.foreman.Foreman
import javax.persistence.*

@Entity
@Table(name = "team", schema = "public")
class Team(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "teamid")
        val id: Long? = null,

        @Column(name = "number")
        val number: String,

        @JoinColumn(name = "foremanid")
        @ManyToOne(fetch = FetchType.EAGER)
        val foreman: Foreman,
)