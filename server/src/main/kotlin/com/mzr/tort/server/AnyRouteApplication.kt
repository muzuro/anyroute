package com.mzr.tort.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class AnyRouteApplication

fun main(args: Array<String>) {
  SpringApplication.run(AnyRouteApplication::class.java, *args)
}
