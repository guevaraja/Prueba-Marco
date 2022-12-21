package eva_andres.demo.repository

import eva_andres.demo.model.Invoice


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository:JpaRepository<Invoice, Long> {

    fun findById(id: Long?):Invoice
    @Query(nativeQuery = true)
    fun findTotalMoreThan(@Param ("total") total: Double?):List<Invoice>?}