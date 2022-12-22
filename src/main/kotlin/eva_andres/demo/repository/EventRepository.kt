package eva_andres.demo.repository

import eva_andres.demo.model.Event
import eva_andres.demo.model.Member


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository:JpaRepository<Event, Long> {

    fun findById(id: Long?):Event
}