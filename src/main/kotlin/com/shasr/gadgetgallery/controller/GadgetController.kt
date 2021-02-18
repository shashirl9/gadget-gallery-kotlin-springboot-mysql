package com.shasr.gadgetgallery.controller


import com.shasr.gadgetgallery.model.Gadget
import com.shasr.gadgetgallery.repository.GadgetRepository
import org.apache.commons.lang3.ObjectUtils
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.InetAddress

@RestController
@RequestMapping("/api")
class GadgetController(private val gadgetRepository: GadgetRepository) {

    @GetMapping("/")
    fun display() : String {
        val hostName = InetAddress.getLocalHost().hostName
        return hostName + "Spring Boot CRUD operation with Kotlin and MySQL...!"
    }

    @GetMapping("/gadgets")
    fun fetchGadgets(): ResponseEntity<List<Gadget>> {
        val gadgets = gadgetRepository.findAll()
        if (gadgets.isEmpty()) {
            return ResponseEntity<List<Gadget>>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<List<Gadget>>(gadgets, HttpStatus.OK)
    }

    @PostMapping("/gadgets")
    fun addNewGadget(@RequestBody gadget: Gadget, uri: UriComponentsBuilder): ResponseEntity<Gadget> {
        val persistedGadget = gadgetRepository.save(gadget)
        if (ObjectUtils.isEmpty(persistedGadget)) {
            return ResponseEntity<Gadget>(HttpStatus.BAD_REQUEST)
        }
        val headers = HttpHeaders()
        headers.setLocation(uri.path("/gadget/{gadgetId}").buildAndExpand(gadget.gadgetId).toUri());
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @GetMapping("/gadgets/{id}")
    fun fetchGadgetById(@PathVariable("id") gadgetId: Long): ResponseEntity<Gadget> {
        val gadget = gadgetRepository.findById(gadgetId)
        if (gadget.isPresent) {
            return ResponseEntity<Gadget>(gadget.get(), HttpStatus.OK)
        }
        return ResponseEntity<Gadget>(HttpStatus.NOT_FOUND)
    }
}
