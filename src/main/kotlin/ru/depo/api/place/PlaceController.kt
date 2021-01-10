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

    @GetMapping("getplacebyplacetype")
    fun getPlaceByPlaceType(@RequestParam placeType: String) = placeService.getPlaceByPlaceType(placeType)

    @GetMapping("getplacebyplacestatus")
    fun getPlaceByPlaceStatus(@RequestParam placeStatus: String) = placeService.getPlaceByPlaceStatus(placeStatus)
}