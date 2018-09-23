package com.mzr.tort.server.domain.entity

import com.mzr.tort.core.domain.LongIdEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class Task: LongIdEntity() {

    @get:ManyToOne(fetch = FetchType.LAZY)
    var route: Route? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    var point: Point? = null
    var number: Int? = null

}