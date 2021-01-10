package ru.depo.api.crash

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface CrashRepository : CrudRepository<Crash, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call changeCrashStatus(:crashIdI, :statusIdI);")
    fun changeCrashStatus(@Param("crashIdI") crashId: Long, @Param("statusIdI") statusId: Long)
}