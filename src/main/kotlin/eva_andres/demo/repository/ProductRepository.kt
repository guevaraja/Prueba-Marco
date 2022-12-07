package eva_andres.demo.repository

import eva_andres.demo.model.Asistente
import eva_andres.demo.model.Product


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository:JpaRepository<Product, Long> {

    fun findById(id: Long?):Product
}