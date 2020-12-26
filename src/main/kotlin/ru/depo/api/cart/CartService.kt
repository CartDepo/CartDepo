package ru.depo.api.cart

import org.springframework.stereotype.Service
import ru.depo.api.exeption.UnsupportedEntityException

@Service
class CartService(
        private val cartRepository: CartRepository
) {
    fun findAll(): List<CartDto> =
            cartRepository.findAll().map {
                CartMapper.toDto(it)
            }

    fun save(cartDto: CartDto): CartDto =
            CartMapper.toDto(cartRepository.save(
                    Cart(
                            number = cartDto.number ?: throw UnsupportedEntityException("Номер вагона не задан"),
                            year = cartDto.year ?: throw UnsupportedEntityException("Год вагона не задан"),
                            contract = cartDto.contract ?: throw UnsupportedEntityException("Договор вагона не задан"),
                            foreman = cartDto.foreman ?: throw UnsupportedEntityException("Бригадир вагона не задан"),
                            place = cartDto.place ?: throw UnsupportedEntityException("Расположение вагона не задан")

                    )
            ))

}