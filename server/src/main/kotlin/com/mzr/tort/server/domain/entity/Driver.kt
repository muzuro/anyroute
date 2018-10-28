package com.mzr.tort.server.domain.entity

import com.mzr.tort.core.domain.LongIdEntity
import javax.persistence.Entity

@Entity
class Driver : LongIdEntity() {

    var name: String? = null

}
