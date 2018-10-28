package com.mzr.tort.server.domain.entity

import com.mzr.tort.core.domain.LongIdEntity
import java.util.*
import javax.persistence.*

@Entity
class Route: LongIdEntity() {

    @get:ManyToOne(fetch = FetchType.LAZY, optional = false)
    var driver: Driver? = null

    var finishTime: Date? = null;

    @get:OneToMany(fetch = FetchType.LAZY, mappedBy = "route", cascade = [CascadeType.ALL])
    var tasks: MutableSet<Task> = HashSet()

}
