package ru.depo.api.crash

import org.springframework.data.repository.CrudRepository

interface CrashRepository : CrudRepository<Crash, Long> {

}