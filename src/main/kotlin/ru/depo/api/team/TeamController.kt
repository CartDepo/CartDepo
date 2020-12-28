package ru.depo.api.team

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("team")
class TeamController (
        private val teamService: TeamService
){
    @GetMapping("all")
    fun getAll(): List<TeamDto> =
            teamService.getAll()

    @PostMapping("save")
    fun save(@RequestBody teamDto: TeamDto): TeamDto =
            teamService.save(teamDto = teamDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            teamService.delete(id = id)

}