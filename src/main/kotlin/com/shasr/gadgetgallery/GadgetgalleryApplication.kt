package com.shasr.gadgetgallery

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition
@SpringBootApplication
class GadgetgalleryApplication

fun main(args: Array<String>) {
    runApplication<GadgetgalleryApplication>(*args)
}
