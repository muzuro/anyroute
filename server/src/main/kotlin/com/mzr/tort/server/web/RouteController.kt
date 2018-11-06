package com.mzr.tort.server.web

import com.mzr.tort.server.domain.dto.RouteDto
import com.mzr.tort.server.service.RouteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RouteController {

    @Autowired
    lateinit var routeService: RouteService;

    @GetMapping("/route")
    fun getRoute(@RequestParam driverId: Long): RouteDto {
        return routeService.findRoute(driverId)
    }

}
