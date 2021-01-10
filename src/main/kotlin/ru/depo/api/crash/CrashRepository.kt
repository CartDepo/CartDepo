package ru.depo.api.crash

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.repository.query.Param

interface CrashRepository : CrudRepository<Crash, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call changeCrashStatus(:crashIdI, :statusIdI);")
    fun changeCrashStatus(@Param("crashIdI") crashId: Long, @Param("statusIdI") statusId: Long)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(
        nativeQuery = true,
        value = "CALL addcrash(:description, :cartid, :typeid, :crashstatusid)"
    )
    fun addCrash(description: String, cartid: Long, typeid: Long, crashstatusid: Long)
}