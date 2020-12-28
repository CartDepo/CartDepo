package ru.depo.api.crash.type

import org.springframework.data.jpa.repository.JpaRepository

interface CrashTypeRepository : JpaRepository<CrashType, Long> {
}