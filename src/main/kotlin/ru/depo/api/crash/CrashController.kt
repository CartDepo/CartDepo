package ru.depo.api.crash

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("crash")
class CrashController(
    private val crashService: CrashService
) {
    @GetMapping("all")
    fun findAll(): List<CrashDto> =
        crashService.getAll()

    @PostMapping("save")
    fun save(@RequestBody crashDto: CrashDto): CrashDto =
        crashService.save(crashDto = crashDto)

    @PostMapping("delete")
    fun delete(@RequestParam id: Long) = crashService.delete(id = id)

    @GetMapping("change-status")
    fun changeStatus(@RequestParam crashId: Long, @RequestParam statusId: Long) =
        crashService.changeStatus(crashId = crashId, statusId = statusId)

    @GetMapping("add")
    fun addCrash(
        @RequestParam description: String,
        @RequestParam cartid: Long,
        @RequestParam typeid: Long,
        @RequestParam crashstatusid: Long
    ) {
        crashService.addCrash(
            description = description,
            cartid = cartid,
            typeid = typeid,
            crashstatusid = crashstatusid
        )
    }

    @GetMapping("getone")
    fun getOne(@RequestParam id: Long) = crashService.getOne(id)
}