package eva_andres.demo.controller


import eva_andres.demo.model.Detail
import eva_andres.demo.model.Product
import eva_andres.demo.service.DetailService
import eva_andres.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/detail")
class DetailController {

    @Autowired
    lateinit var detailService: DetailService

    @GetMapping
    fun list():List<Detail>{
        return detailService.list()
    }

    @PostMapping
    fun save(@RequestBody detail: Detail):Detail{
        return detailService.save(detail)
    }

    @PutMapping
    fun update (@RequestBody detail: Detail): ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail),HttpStatus.OK )
    }

    @PatchMapping
    fun updateStock (@RequestBody detail:Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.updatequantity(detail), HttpStatus.OK)
    }

}