package ru.depo.api.cart

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import java.time.Year

interface CartRepository : JpaRepository<Cart, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "CALL addcart(:number, :cartyear, :contractid, :clientid, :placeid, :teamid)")
    fun addCart(number: String, cartyear: Int, contractid: Long, clientid: Long, placeid: Long, teamid: Long)
}