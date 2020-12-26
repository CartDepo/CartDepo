package ru.depo.api.placeType

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceTypeRepository: JpaRepository<PlaceType, Long> {
}