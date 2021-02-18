package com.shasr.gadgetgallery

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition
@SpringBootApplication
class GadgetgalleryApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("SpringBoot - Kotlin application started..!")
    }
}

fun main(args: Array<String>) {
    runApplication<GadgetgalleryApplication>(*args)
}
