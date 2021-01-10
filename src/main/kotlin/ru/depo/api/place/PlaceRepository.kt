package ru.depo.api.place

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.query.Param

interface PlaceRepository : JpaRepository<Place, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM getplacebyplacetype(:placetype)")
    fun getPlaceByPlaceType(@Param("placetype") placeType: String): List<Place>

    @Query(nativeQuery = true, value = "SELECT * FROM getplacebyplacestatus(:placestatus)")
    fun getPlaceByPlaceStatus(@Param("placestatus") placeStatus: String): List<Place>
}