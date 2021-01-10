package ru.depo.api.place

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface PlaceRepository : JpaRepository<Place, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call changePlaceStatus(:placeIdI, :placeStatusIdI);")
    fun changePlaceStatus(@Param("placeIdI") placeId: Long,
                          @Param("placeStatusIdI") placeStatusId: Long
    )
}