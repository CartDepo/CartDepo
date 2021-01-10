package ru.depo.api.detail.type

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface DetailTypeRepository : JpaRepository<DetailType, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call addDetail(:detailTypeIdI, :amountI);")
    fun addDetail(@Param("detailTypeIdI") detailTypeId: Long, @Param("amountI") amount: Long)
}