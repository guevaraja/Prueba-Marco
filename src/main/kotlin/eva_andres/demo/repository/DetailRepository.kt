package eva_andres.demo.repository

import eva_andres.demo.model.Asistente
import eva_andres.demo.model.Detail


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository:JpaRepository<Detail, Long> {

    fun findById(id: Long?):Detail?
    @Query(nativeQuery =true)
    fun sumTotal(@Param ("invoiceId") invoiceId: Long?): Double?






}

