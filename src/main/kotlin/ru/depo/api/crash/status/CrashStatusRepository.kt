package ru.depo.api.crash.status

import org.springframework.data.jpa.repository.JpaRepository

interface CrashStatusRepository : JpaRepository<CrashStatus, Long> {
}