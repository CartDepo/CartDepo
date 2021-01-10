package ru.depo.api.crash

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CrashRepository : CrudRepository<Crash, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(
        nativeQuery = true,
        value = "CALL addcrash(:description, :cartid, :typeid, :crashstatusid)"
    )
    fun addCrash(description: String, cartid: Long, typeid: Long, crashstatusid: Long)
}