package ru.depo.api.client

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("client")
class ClientController(
        private val clientService: ClientService
) {
    @GetMapping("all")
    fun getAll(): List<ClientDto> =
            clientService.getAll()

    @PostMapping("save")
    fun save(@RequestBody clientDto: ClientDto): ClientDto =
            clientService.save(clientDto = clientDto)

    @DeleteMapping("delete")
    fun delete(clientDto: ClientDto) =
            clientService.delete(clientDto = clientDto)
}