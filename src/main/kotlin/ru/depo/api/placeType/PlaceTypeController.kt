package ru.depo.api.placeType

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("place-type")
class PlaceTypeController (
        private val placeTypeService: PlaceTypeService
){
    @GetMapping("all")
    fun getAll(): List<PlaceTypeDto> =
            placeTypeService.getAll()

    @PostMapping("save")
    fun save(@RequestBody placeTypeDto: PlaceTypeDto): PlaceTypeDto =
            placeTypeService.save(placeTypeDto = placeTypeDto)

    @DeleteMapping("delete")
    fun delete(placeTypeDto: PlaceTypeDto) =
            placeTypeService.delete(placeTypeDto = placeTypeDto)

}