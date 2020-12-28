package ru.depo.api.detail.type

import org.springframework.data.jpa.repository.JpaRepository

interface DetailTypeRepository : JpaRepository<DetailType, Long> {
}