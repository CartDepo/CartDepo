package ru.depo.api.contract

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

interface ContractRepository : JpaRepository<Contract, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(
        nativeQuery = true,
        value = "CALL addcontract(:contractdate, :cost, :number, :clientid, :managerid, :contractstatusid)"
    )
    fun addContract(
        contractdate: LocalDate,
        cost: Long,
        number: String,
        clientid: Long,
        managerid: Long,
        contractstatusid: Long
    )
}