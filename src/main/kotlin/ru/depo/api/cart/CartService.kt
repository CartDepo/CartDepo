package ru.depo.api.cart

import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import ru.depo.api.contract.ContractService
import ru.depo.api.exeption.UnsupportedEntityException
import ru.depo.api.place.PlaceService
import ru.depo.api.place.type.PlaceTypeService
import ru.depo.api.team.TeamService
import javax.persistence.EntityNotFoundException

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
                                    ?: throw UnsupportedEntityException("УИД расположения вагона не задан"))
                    )
            ))

    fun delete(cartDto: CartDto) = cartRepository.deleteById(cartDto.id
            ?: throw UnsupportedEntityException("УИД вагона не задан"))

    fun getOne(cartId: Long) = cartRepository.getOne(cartId)

    fun changeCartTeam(cartId: Long, teamId: Long): CartDto {
        cartRepository.changeCartTeam(cartId, teamId)
        return cartRepository.findByIdOrNull(cartId)?.let { CartMapper.toDto(it) } ?: throw EntityNotFoundException("Не найден вагон с УИД=$cartId")
    }

    fun changePlace(cartId: Long, placeId: Long): CartDto{
        cartRepository.changePlace(cartId, placeId)
        return cartRepository.findByIdOrNull(cartId)?.let { CartMapper.toDto(it) } ?: throw EntityNotFoundException("Не найден вагон с УИД=$cartId")
    }

}