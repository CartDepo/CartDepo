package ru.depo.api.detailtype

import org.springframework.data.jpa.repository.JpaRepository

interface DetailTypeRepository: JpaRepository<DetailType, Long> {
}