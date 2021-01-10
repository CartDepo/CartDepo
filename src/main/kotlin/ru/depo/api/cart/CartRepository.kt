package ru.depo.api.cart

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface CartRepository : JpaRepository<Cart, Long>{
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call changeCartTeam(:cartIdI , :teamIdI);")
    fun changeCartTeam(@Param("cartIdI") cartId: Long, @Param("teamIdI") teamId: Long)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "call changePlace(:cartIdI, :placeIdI);")
    fun changePlace(@Param("cartIdI") cartId: Long, @Param("placeIdI") placeId: Long)


}