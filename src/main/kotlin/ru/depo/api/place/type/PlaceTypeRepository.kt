package ru.depo.api.place.type

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceTypeRepository : JpaRepository<PlaceType, Long> {
}