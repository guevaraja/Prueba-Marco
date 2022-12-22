package eva_andres.demo.controller

import eva_andres.demo.model.Register
import eva_andres.demo.service.RegisterService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class RegisterController {

    @Autowired
    lateinit var invoiceService: RegisterService

    @GetMapping
    fun list():List<Register>{
        return invoiceService.list()
    }
    @GetMapping("/totals/{total}")
    fun listTotals (@PathVariable("total") totalAttendees: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listTotalMoreThan(totalAttendees), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody invoice: Register):Register{
        return invoiceService.save(invoice)
    }

    @PutMapping
    fun update (@RequestBody invoice: Register): ResponseEntity<Register>{
        return ResponseEntity(invoiceService.update(invoice),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody invoice:Register):ResponseEntity<Register>{
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.OK)
    }

}