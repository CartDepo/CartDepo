package ru.depo.api.contract.status

import org.springframework.data.jpa.repository.JpaRepository

interface ContractStatusRepository : JpaRepository<ContractStatus, Long> {
}