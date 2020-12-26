package ru.depo.api.cart

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class CartController {
    @GetMapping("")
    fun testGet(): String = "Shit"
}