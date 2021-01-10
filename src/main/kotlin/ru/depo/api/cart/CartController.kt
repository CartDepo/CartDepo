package ru.depo.api.cart

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cart")
class CartController(
    private val cartService: CartService
) {
    @GetMapping("all")
    fun findAll(): List<CartDto> =
        cartService.getAll()

    @PostMapping("save")
    fun save(@RequestBody cartDto: CartDto): CartDto =
        cartService.save(cartDto = cartDto)

    @GetMapping("add")
    fun addCart(
        @RequestParam number: String,
        @RequestParam cartyear: Int,
        @RequestParam contractid: Long,
        @RequestParam clientid: Long,
        @RequestParam placeid: Long,
        @RequestParam teamid: Long
    ) {
        cartService.addCart(number, cartyear, contractid, clientid, placeid, teamid)
    }
}