package com.mzr.tort.server.domain.entity

import com.mzr.tort.core.domain.LongIdEntity
import javax.persistence.Entity

@Entity
class Point : LongIdEntity() {

    var name: String? = null;
    var lat: Float? = null;
    var lng: Float? = null;

}