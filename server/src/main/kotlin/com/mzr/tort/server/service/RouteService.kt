package com.mzr.tort.server.service

import com.mzr.tort.core.extractor.DtoExtractor
import com.mzr.tort.server.domain.dto.RouteDto
import com.mzr.tort.server.domain.entity.Driver
import com.mzr.tort.server.domain.entity.Route
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.function.BiFunction
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.From

@Component
class RouteService {

    @Autowired
    lateinit var dtoExtractor: DtoExtractor

    @Autowired
    lateinit var entityManager: EntityManager

    var some: From<Void, Void>? = null;

    fun findRoute(driverId: Long): RouteDto {
        val driverRef = entityManager.getReference(Driver::class.java, driverId)

        return dtoExtractor.extract(RouteDto::class.java, Route::class.java)
                .filter(BiFunction { cb: CriteriaBuilder, from: From -> cb.equal(from.get("driver"), driverRef) })
                .filter(BiFunction { cb: CriteriaBuilder, from: From -> cb.isNotNull(from.get("finishTime")) })
                .singleDto()
    }

}
