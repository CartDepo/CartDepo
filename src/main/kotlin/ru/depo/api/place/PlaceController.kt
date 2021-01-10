package ru.depo.api.place

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("place")
class PlaceController(
        private val placeService: PlaceService
) {
    @GetMapping("all")
    fun getAll(): List<PlaceDto> =
            placeService.getAll()

    @PostMapping("save")
    fun save(@RequestBody placeDto: PlaceDto): PlaceDto =
            placeService.save(placeDto = placeDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            placeService.delete(id = id)

    @GetMapping("change-status")
    fun changePlaceStatus(@RequestParam placeId: Long, @RequestParam placeStatusId: Long): PlaceDto =
            placeService.changePlaceStatus(placeId, placeStatusId)
}