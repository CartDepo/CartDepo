package ru.depo.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.depo.api.cart.CartService
import ru.depo.api.contract.ContractService
import ru.depo.api.contract.status.ContractStatusService
import ru.depo.api.crash.CrashService
import ru.depo.api.crash.type.CrashTypeService
import ru.depo.api.detail.DetailService
import ru.depo.api.foreman.ForemanService
import ru.depo.api.manager.ManagerService
import ru.depo.api.place.PlaceService
import ru.depo.api.place.status.PlaceStatusService
import ru.depo.api.place.type.PlaceTypeService
import ru.depo.api.team.TeamService

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private val contractStatusService: ContractStatusService? = null

    @Autowired
    private val clientService: ContractStatusService? = null

    @Autowired
    private val contractService: ContractService? = null

    @Autowired
    private val managerService: ManagerService? = null

    @Autowired
    private val crashService: CrashService? = null

    @Autowired
    private val crashTypeService: CrashTypeService? = null

    @Autowired
    private val crashStatusService: ContractStatusService? = null

    @Autowired
    private val foremanService: ForemanService? = null

    @Autowired
    private val teamService: TeamService? = null

    @Autowired
    private val detailService: DetailService? = null

    @Autowired
    private val detailTypeService: PlaceTypeService? = null

    @Autowired
    private val placeTypeService: PlaceTypeService? = null

    @Autowired
    private val placeStatusService: PlaceStatusService? = null

    @Autowired
    private val placeService: PlaceService? = null

    @Autowired
    private val cartService: CartService? = null

    @Test
    fun contextLoads() {
    }

    @Test
    fun testEntities() {
        contractStatusService?.getAll()
        clientService?.getAll()
        contractService?.getAll()
        managerService?.getAll()
        crashService?.getAll()
        crashTypeService?.getAll()
        crashStatusService?.getAll()
        foremanService?.getAll()
        teamService?.getAll()
        detailService?.getAll()
        detailTypeService?.getAll()
        placeTypeService?.getAll()
        placeStatusService?.getAll()
        placeService?.getAll()
        cartService?.getAll()
    }

}
