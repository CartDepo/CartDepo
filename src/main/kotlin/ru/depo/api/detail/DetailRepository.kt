package ru.depo.api.detail

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface DetailRepository : CrudRepository<Detail, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call addDetailToCart(:detailTypeIdI, :cartIdI, :serialNumber);")
    fun addDetailToCart(@Param("detailTypeIdI") detailTypeId: Long,
                        @Param("cartIdI") cartId: Long,
                        @Param("serialNumber") serialNumber: String
    )
}