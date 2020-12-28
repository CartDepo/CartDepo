package ru.depo.api.placeStatus

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceStatusRepository: JpaRepository<PlaceStatus, Long> {
}