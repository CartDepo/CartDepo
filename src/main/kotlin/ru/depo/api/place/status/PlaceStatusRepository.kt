package ru.depo.api.place.status

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceStatusRepository : JpaRepository<PlaceStatus, Long> {
}