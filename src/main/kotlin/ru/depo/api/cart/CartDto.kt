package ru.depo.api.cart

data class CartDto(
    val id: Long? = null,
    val number: String? = null,
    val year: Int? = null,
    val contract: Long? = null,
    val foreman: Long? = null,
    val place: Long? = null
)