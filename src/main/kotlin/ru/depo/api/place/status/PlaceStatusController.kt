package ru.depo.api.place.status

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("place-status")
class PlaceStatusController(
        private val placeStatusService: PlaceStatusService
) {
    @GetMapping("all")
    fun getAll(): List<PlaceStatusDto> =
            placeStatusService.getAll()

    @PostMapping("save")
    fun save(@RequestBody placeStatusDto: PlaceStatusDto): PlaceStatusDto =
            placeStatusService.save(placeStatusDto = placeStatusDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            placeStatusService.delete(id = id)

}