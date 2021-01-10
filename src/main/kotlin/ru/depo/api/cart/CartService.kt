package ru.depo.api.cart

import org.springframework.stereotype.Service
import ru.depo.api.contract.ContractService
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.foreman.ForemanService
import ru.depo.api.place.PlaceService
import ru.depo.api.place.type.PlaceTypeService
import ru.depo.api.team.TeamService

@Service
class CartService(
        private val cartRepository: CartRepository,
        private val contractService: ContractService,
        private val teamService: TeamService,
        private val placeService: PlaceService,
        private val placeTypeService: PlaceTypeService
) {
    fun getAll(): List<CartDto> =
            cartRepository.findAll().map {
                CartMapper.toDto(it)
            }

    fun save(cartDto: CartDto): CartDto =
            CartMapper.toDto(cartRepository.save(
                    Cart(
                            number = cartDto.number ?: throw UnsupportedEntityException("Номер вагона не задан"),
                            year = cartDto.year ?: throw UnsupportedEntityException("Год вагона не задан"),
                            contract = contractService.getOne(cartDto.contract?.id
                                    ?: throw UnsupportedEntityException("УИД договора вагона не задан")),
                            team = teamService.getOne(cartDto.team?.id
                                    ?: throw UnsupportedEntityException("УИД бригады вагона не задан")),
                            place = placeService.getOne(cartDto.place?.id
                                    ?: throw UnsupportedEntityException("УИД расположения вагона не задан")),
                            placeType = placeTypeService.getOne(cartDto.placeType?.id
                                    ?: throw UnsupportedEntityException("УИД типа расположения вагона не задан"))

                    )
            ))

    fun delete(cartDto: CartDto) = cartRepository.deleteById(cartDto.id
            ?: throw UnsupportedEntityException("УИД вагона не задан"))

    fun getOne(cartId: Long) = cartRepository.getOne(cartId)
}