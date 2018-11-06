package com.mzr.tort.server.service

import com.mzr.tort.core.dao.SimpleDao
import com.mzr.tort.core.extractor.DtoExtractor
import com.mzr.tort.server.domain.dto.RouteDto
import com.mzr.tort.server.domain.entity.Driver
import com.mzr.tort.server.domain.entity.Route
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager

@Component
class RouteService {

    @Autowired
    lateinit var dtoExtractor: DtoExtractor

    @Autowired
    lateinit var entityManager: EntityManager

    @Autowired
    lateinit var simpleDao: SimpleDao

    fun findRoute(driverId: Long): RouteDto {
        val driverRef = entityManager.getReference(Driver::class.java, driverId)

        return dtoExtractor.extract(RouteDto::class.java, Route::class.java)
                .filter{cb, from -> cb.equal(from.get<Driver>("driver"), driverRef)}
                .filter{cb, from -> cb.isNull(from.get<Date>("finishTime"))}
                .singleDto()
    }

}
