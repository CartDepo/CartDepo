package ru.depo.api.cart

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.depo.api.contract.ContractService
import ru.depo.api.crash.CrashRepository
import ru.depo.api.crash.CrashService
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
    private val crashRepository: CrashRepository
) {
    fun getAll(): List<CartDto> =
        cartRepository.findAll().map {
            CartMapper.toDto(it)
        }

    fun findById(id: Long): CartDto =
            cartRepository.findByIdOrNull(id)?.let {
                CartMapper.toDtoWithCrashes(it, crashRepository.findByCartId(id))
            } ?: throw EntityNotFoundException("Не найден вагон с УИД=$id")


    fun save(cartDto: CartDto): CartDto =
        CartMapper.toDto(
            cartRepository.save(
                Cart(
                    id = cartDto.id,
                    number = cartDto.number ?: throw UnsupportedEntityException("Номер вагона не задан"),
                    year = cartDto.year ?: throw UnsupportedEntityException("Год вагона не задан"),
                    contract = contractService.getOne(
                        cartDto.contract?.id
                            ?: throw UnsupportedEntityException("УИД договора вагона не задан")
                    ),
                    team = teamService.getOne(
                        cartDto.team?.id
                            ?: throw UnsupportedEntityException("УИД бригады вагона не задан")
                    ),
                    place = placeService.getOne(
                        cartDto.place?.id
                            ?: throw UnsupportedEntityException("УИД расположения вагона не задан")
                    )
                )
            )
        )

    fun delete(cartDto: CartDto) = cartRepository.deleteById(
        cartDto.id
            ?: throw UnsupportedEntityException("УИД вагона не задан")
    )

    fun getOne(cartId: Long) = cartRepository.getOne(cartId)

    fun addCart(number: String, cartyear: Int, contractid: Long, clientid: Long, placeid: Long, teamid: Long) {
        cartRepository.addCart(
            number = number,
            cartyear = cartyear,
            contractid = contractid,
            clientid = clientid,
            placeid = placeid,
            teamid = teamid
        )
    }

    fun changeCartTeam(cartId: Long, teamId: Long): CartDto {
        cartRepository.changeCartTeam(cartId, teamId)
        return cartRepository.findByIdOrNull(cartId)?.let { CartMapper.toDto(it) }
            ?: throw EntityNotFoundException("Не найден вагон с УИД=$cartId")
    }

    fun changePlace(cartId: Long, placeId: Long): CartDto {
        cartRepository.changePlace(cartId, placeId)
        return cartRepository.findByIdOrNull(cartId)?.let { CartMapper.toDto(it) }
            ?: throw EntityNotFoundException("Не найден вагон с УИД=$cartId")
    }

    fun change(cartId: Long, placeId: Long, teamId: Long): CartDto {
        cartRepository.changePlace(cartId, placeId)
        cartRepository.changeCartTeam(cartId, teamId)
        return cartRepository.findByIdOrNull(cartId)?.let { CartMapper.toDto(it) }
                ?: throw EntityNotFoundException("Не найден вагон с УИД=$cartId")
    }

}