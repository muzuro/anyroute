package com.mzr.tort.server.domain.entity

import com.mzr.tort.core.domain.LongIdEntity
import javax.persistence.Entity

@Entity
class Point : LongIdEntity {

    constructor(name: String?, lat: Float?, lng: Float?) : super() {
        this.name = name
        this.lat = lat
        this.lng = lng
    }

    var name: String? = null;
    var lat: Float? = null;
    var lng: Float? = null;

}
