package ru.depo.api.manager

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("manager")
class ManagerController (
        private val managerService: ManagerService
){
    @GetMapping("all")
    fun getAll(): List<ManagerDto> =
            managerService.getAll()

    @PostMapping("save")
    fun save(@RequestBody managerDto: ManagerDto): ManagerDto =
            managerService.save(managerDto = managerDto)

    @DeleteMapping("delete")
    fun delete(managerDto: ManagerDto) =
            managerService.delete(managerDto = managerDto)

}