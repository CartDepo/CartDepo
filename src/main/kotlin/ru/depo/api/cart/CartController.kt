package ru.depo.api.cart

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
class CartController {
    @GetMapping("")
    fun testGet(): String = "Shit"

    @GetMapping("all/{beach}")
    fun test2Get(
            @PathVariable beach: String,
            @RequestParam str: String
    ) = str + beach
}