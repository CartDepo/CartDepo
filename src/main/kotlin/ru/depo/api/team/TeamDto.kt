package ru.depo.api.team

import ru.depo.api.foreman.ForemanDto

class TeamDto(
        val id: Long? = null,
        val number: String? = null,
        val foreman: ForemanDto? = null
)