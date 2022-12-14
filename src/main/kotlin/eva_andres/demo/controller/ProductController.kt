package eva_andres.demo.controller


import eva_andres.demo.model.Product
import eva_andres.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/product")
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list (product:Product, pageable: Pageable):ResponseEntity<*>{
        val response= productService.list(pageable ,product)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody product: Product):Product{
        return productService.save(product)
    }

    @PutMapping
    fun update (@RequestBody product: Product): ResponseEntity<Product>{
        return ResponseEntity(productService.update(product),HttpStatus.OK )
    }

    @PatchMapping
    fun updateStock (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.updateStock(product), HttpStatus.OK)
    }


}