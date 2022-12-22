package eva_andres.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name="Event")
class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
    @NotBlank
    var startDate: String? = null
    @NotBlank
    var endDate: String? = null
    @NotBlank
    var totalAttendees: String? = null
    var city: String? = null

}