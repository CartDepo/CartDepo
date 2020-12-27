package ru.depo.api.detail

import org.springframework.web.bind.annotation.*
import ru.depo.api.cart.CartDto
import ru.depo.api.cart.CartService

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

}