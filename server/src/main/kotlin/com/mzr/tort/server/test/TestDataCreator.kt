package com.mzr.tort.server.test

import com.mzr.tort.core.dao.SimpleDao
import com.mzr.tort.server.domain.entity.Driver
import com.mzr.tort.server.domain.entity.Point
import com.mzr.tort.server.domain.entity.Route
import com.mzr.tort.server.domain.entity.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class TestDataCreator {

    @Autowired
    lateinit var simpleDao: SimpleDao;

    @PostConstruct
    fun init() {
        var driver = Driver()
        driver.name = "Jonh Dow"
        simpleDao.save(driver)

        var route = Route()
        route.driver = driver
        simpleDao.save(route)

        val firstPoint = Point("Shmidta, 35A", 55.789088f, 49.160697f)
        simpleDao.save(firstPoint)

        var firstTask = Task()
        firstTask.number = 0
        firstTask.point = firstPoint
        firstTask.route = route
        simpleDao.save(firstTask)

        val secondPoint = Point("Zinina, 20", 55.788316f, 49.154816f)
        simpleDao.save(secondPoint)

        var secondTask = Task()
        secondTask.number = 1
        secondTask.point = secondPoint
        secondTask.route = route
        simpleDao.save(secondTask)

        val thirdPoint = Point("Adoratskogo, 13", 55.825436f, 49.146876f)
        simpleDao.save(thirdPoint)

        var thirdTask = Task()
        thirdTask.number = 3
        thirdTask.point = thirdPoint
        thirdTask.route = route
        simpleDao.save(thirdTask)
    }

}
