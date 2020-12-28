package ru.depo.api.place.type

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("place-type")
class PlaceTypeController(
        private val placeTypeService: PlaceTypeService
) {
    @GetMapping("all")
    fun getAll(): List<PlaceTypeDto> =
            placeTypeService.getAll()

    @PostMapping("save")
    fun save(@RequestBody placeTypeDto: PlaceTypeDto): PlaceTypeDto =
            placeTypeService.save(placeTypeDto = placeTypeDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            placeTypeService.delete(id = id)

}