package ru.depo.api.foreman

import org.springframework.data.jpa.repository.JpaRepository

interface ForemanRepository : JpaRepository<Foreman, Long> {
}