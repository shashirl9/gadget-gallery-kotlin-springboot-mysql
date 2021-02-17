package com.shasr.gadgetgallery.model

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "GADGET")
data class Gadget(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val gadgetId: Long,
    val gadgetName: String,
    val gadgetCategory: String?,
    val gagdetAvailability: Boolean = true,
    val gadgetPrice: Double
)
