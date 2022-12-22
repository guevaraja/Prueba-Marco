package eva_andres.demo.repository

import eva_andres.demo.model.Register


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository:JpaRepository<Register, Long> {

    fun findById(id: Long?):Register
    @Query(nativeQuery = true)
    fun findTotalMoreThan(@Param ("total") total: Double?):List<Register>?}