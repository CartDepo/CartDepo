package ru.depo.api.foreman

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("foreman")
class ForemanController(
        private val foremanService: ForemanService
) {
    @GetMapping("all")
    fun getAll(): List<ForemanDto> =
            foremanService.getAll()

    @PostMapping("save")
    fun save(@RequestBody foremanDto: ForemanDto): ForemanDto =
            foremanService.save(foremanDto = foremanDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            foremanService.delete(id = id)

}