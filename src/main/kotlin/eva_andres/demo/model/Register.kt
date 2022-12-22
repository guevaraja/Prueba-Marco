package eva_andres.demo.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="invoice")
class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="member_id")
    var memberId: Long? = null
    @Column (name="conference_id")
    var conferenceId: Long? = null
    var code: String? = null
    @Column (name="registered_at")
    var registeredAt: Date? = null
    var assisted: Boolean? = null

}