package ru.depo.api.team

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TeamRepository : JpaRepository<Team, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM getTeamByPredicate(:numberI, :foremanIdI);")
    fun getTeamByPredicate(@Param("numberI", ) number: String?, @Param("foremanIdI") foremanId: Long?): List<Team>

    @Query(nativeQuery = true, value = "SELECT * FROM getfreeteam()")
    fun getFreeTeam(): List<Team>
}