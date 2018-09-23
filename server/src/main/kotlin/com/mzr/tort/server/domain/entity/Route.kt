package com.mzr.tort.server.domain.entity

import com.mzr.tort.core.domain.LongIdEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany

@Entity
class Route: LongIdEntity() {

    @get:OneToMany(fetch = FetchType.LAZY, mappedBy = "route", cascade = [CascadeType.ALL])
    var tasks: MutableSet<Task> = HashSet()

}