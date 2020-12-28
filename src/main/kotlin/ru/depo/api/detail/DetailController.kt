package ru.depo.api.detail

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("detail")
class DetailController(
        private val detailService: DetailService
) {
    @GetMapping("all")
    fun findAll(): List<DetailDto> =
            detailService.getAll()

    @PostMapping("save")
    fun save(@RequestBody detailDto: DetailDto): DetailDto =
            detailService.save(detailDto = detailDto)

    @PostMapping("delete")
    fun delete(@RequestParam id: Long) = detailService.delete(id = id)
}