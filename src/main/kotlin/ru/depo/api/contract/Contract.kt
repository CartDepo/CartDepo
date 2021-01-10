package ru.depo.api.contract

import ru.depo.api.client.Client
import ru.depo.api.contract.status.ContractStatus
import ru.depo.api.manager.Manager
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "contract", schema = "public")
class Contract(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "contractid")
        val id: Long? = null,

        @Column(name = "contractdate")
        val contractDate: LocalDate,

        @Column(name = "cost")
        val cost: BigDecimal,

        @Column(name = "number")
        val number: String,

        @JoinColumn(name = "clientid")
        @ManyToOne(fetch = FetchType.EAGER)
        val client: Client,

        @JoinColumn(name = "managerid")
        @ManyToOne(fetch = FetchType.EAGER)
        val manager: Manager,

        @JoinColumn(name = "contractstatusid")
        @ManyToOne(fetch = FetchType.EAGER)
        val status: ContractStatus,
)