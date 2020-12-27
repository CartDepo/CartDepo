package ru.depo.api.detailtype

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("detail-type")
class DetailTypeController (
        private val detailTypeService: DetailTypeService
){
    @GetMapping("all")
    fun getAll(): List<DetailTypeDto> =
            detailTypeService.getAll()

    @PostMapping("save")
    fun save(@RequestBody detailTypeDto: DetailTypeDto): DetailTypeDto =
            detailTypeService.save(detailTypeDto = detailTypeDto)

    @DeleteMapping("delete")
    fun delete(detailTypeDto: DetailTypeDto) =
            detailTypeService.delete(detailTypeDto = detailTypeDto)

}