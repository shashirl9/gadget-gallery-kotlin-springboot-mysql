package com.shasr.gadgetgallery.repository

import com.shasr.gadgetgallery.model.Gadget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GadgetRepository : JpaRepository<Gadget, Long>