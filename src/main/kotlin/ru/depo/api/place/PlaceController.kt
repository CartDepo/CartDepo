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

    @GetMapping("getplacebyplacetype")
    fun getPlaceByPlaceType(@RequestParam placeType: Long) = placeService.getPlaceByPlaceType(placeType)

    @GetMapping("getplacebyplacestatus")
    fun getPlaceByPlaceStatus(@RequestParam placeStatus: Long) = placeService.getPlaceByPlaceStatus(placeStatus)

    @GetMapping("free")
    fun getFreePlaceByPlaceType(@RequestParam placeType: Long) = placeService.getFreePlaceByPlaceType(placeType)
}