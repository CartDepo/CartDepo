package ru.depo.api.detail.type

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("detail-type")
class DetailTypeController(
        private val detailTypeService: DetailTypeService
) {
    @GetMapping("all")
    fun getAll(): List<DetailTypeDto> =
            detailTypeService.getAll()

    @PostMapping("save")
    fun save(@RequestBody detailTypeDto: DetailTypeDto): DetailTypeDto =
            detailTypeService.save(detailTypeDto = detailTypeDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
            detailTypeService.delete(id = id)

    @GetMapping("add")
    fun addDetail(@RequestParam detailTypeId: Long, @RequestParam amount: Long): DetailTypeDto =
            detailTypeService.addDetail(detailTypeId, amount)
}