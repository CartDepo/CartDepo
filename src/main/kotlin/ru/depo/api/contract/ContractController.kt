package ru.depo.api.contract

import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("contract")
class ContractController(
    private val contractService: ContractService
) {
    @GetMapping("all")
    fun getAll(): List<ContractDto> =
        contractService.getAll()

    @PostMapping("save")
    fun save(@RequestBody contractDto: ContractDto): ContractDto =
        contractService.save(contractDto = contractDto)

    @DeleteMapping("delete")
    fun delete(@RequestParam id: Long) =
        contractService.delete(id = id)

    @GetMapping("add")
    fun addContract(
        @RequestParam contractdate: String,
        @RequestParam cost: Long,
        @RequestParam number: String,
        @RequestParam clientid: Long,
        @RequestParam managerid: Long,
        @RequestParam contractstatusid: Long
    ) {
        contractService.addContract(
            contractDate = contractdate,
            cost = cost,
            number = number,
            clientid = clientid,
            managerid = managerid,
            contractstatusid = contractstatusid
        )
    }
}