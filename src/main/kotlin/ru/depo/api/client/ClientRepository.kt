package ru.depo.api.client

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface ClientRepository : JpaRepository<Client, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "CALL addclient(:fio, :pasportserial, :pasportnumber, :phonenumber)")
    fun addClient(fio: String, pasportserial: String, pasportnumber: String, phonenumber: String)
}