package ru.depo.api.team

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.foreman.ForemanService

@Service
class TeamService(
    private val teamRepository: TeamRepository,
    private val foremanService: ForemanService
) {
    fun getAll(): List<TeamDto> =
        teamRepository.findAll().map {
            TeamMapper.toDto(it)
        }

    fun save(teamDto: TeamDto): TeamDto =
        TeamMapper.toDto(
            teamRepository.save(
                Team(
                    id = teamDto.id,
                    number = teamDto.number
                        ?: throw UnsupportedEntityException("Номер бригады не задан"),
                    foreman = foremanService.getOne(
                        teamDto.foreman?.id
                            ?: throw UnsupportedEntityException("УИД бригадира не задан")
                    )
                )
            )
        )

    fun delete(id: Long) =
        teamRepository.deleteById(id)

    fun getOne(id: Long) =
        teamRepository.getOne(id)

    fun getTeamByPredicate(number: String?, foremanId: Long?): List<TeamDto> =
        teamRepository.getTeamByPredicate(number = number, foremanId = foremanId).map {
            TeamMapper.toDto(it)
        }

    fun getFreeTeam() = teamRepository.getFreeTeam().map(TeamMapper::toDto)
}