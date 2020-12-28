package ru.depo.api.contract

import org.springframework.data.jpa.repository.JpaRepository

interface ContractRepository : JpaRepository<Contract, Long> {
}