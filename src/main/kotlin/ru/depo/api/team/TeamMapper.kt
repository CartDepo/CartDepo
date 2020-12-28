package ru.depo.api.team

import ru.depo.api.foreman.ForemanMapper

object TeamMapper {
    fun toDto(entity: Team): TeamDto =
            TeamDto(
                    id = entity.id,
                    number = entity.number,
                    foreman = ForemanMapper.toDto(entity.foreman)
            )
}