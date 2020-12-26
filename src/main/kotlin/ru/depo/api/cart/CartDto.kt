package ru.depo.api.cart

data class CartDto(
    val id: Long?,
    val number: String?,
    val year: Int?,
    val contract: Long?,
    val foreman: Long?,
    val place: Long?
)