package ru.depo.api.cart

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cart")
class CartController(
        private val cartService: CartService
) {
    @GetMapping("all")
    fun findAll(): List<CartDto> =
            cartService.findAll()

    @PostMapping("save")
    fun save(@RequestBody cartDto: CartDto): CartDto =
            cartService.save(cartDto = cartDto)

}