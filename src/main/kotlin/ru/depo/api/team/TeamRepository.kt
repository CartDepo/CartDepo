package ru.depo.api.team

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TeamRepository : JpaRepository<Team, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM getfreeteam()")
    fun getFreeTeam(): List<Team>
}