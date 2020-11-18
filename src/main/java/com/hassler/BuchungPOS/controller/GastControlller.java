package com.hassler.BuchungPOS.controller;

import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.domain.Gast;
import com.hassler.BuchungPOS.repository.BuchungRepository;
import com.hassler.BuchungPOS.repository.GastRepository;
import com.hassler.BuchungPOS.servicelayer.GastService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GastControlller {

    @Autowired
    GastRepository gastRepository;

    private final GastService gastService;
    @Autowired
    public GastControlller(GastService gastService) {
        this.gastService = gastService;
    }

    @GetMapping("/gast")
    public Gast getAllGast() {
        return (Gast) gastRepository.findAll();
    }

    @PostMapping("/gast")
    public Gast createPost(@Valid @RequestBody Gast gast) {
        return gastRepository.save(gast);
    }

    @PutMapping("/gast/{gastId}")
    public Gast updatePost(@PathVariable Long gastId, @Valid @RequestBody Gast gast2) {
        return gastRepository.findById(gastId).map(gast -> {
            gast.setName(gast2.getName());
            return gastRepository.save(gast);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + gastId + " not found"));
    }


    @DeleteMapping("/gast/{gastId}")
    public ResponseEntity<?> deletePost(@PathVariable Long gastId) {
        return gastRepository.findById(gastId).map(gast -> {
            gastRepository.delete(gast);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + gastId + " not found"));
    }


}
