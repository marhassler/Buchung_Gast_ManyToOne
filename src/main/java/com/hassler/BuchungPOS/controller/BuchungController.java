package com.hassler.BuchungPOS.controller;


import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.repository.BuchungRepository;
import com.hassler.BuchungPOS.repository.GastRepository;
import com.hassler.BuchungPOS.servicelayer.BuchungService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BuchungController {

    @Autowired
    GastRepository gastRepository;

    @Autowired
    BuchungRepository buchungRepository;

    private final BuchungService buchungService;
    @Autowired
    public BuchungController(BuchungService buchungService) {
        this.buchungService = buchungService;
    }
    
    @PostMapping("gast/{gastId}/buchung")
    public Buchung createBuchung(@PathVariable (value = "gastId") Long gastId,
            @RequestBody Buchung buchung)
    {
        return gastRepository.findById(gastId).map(gast -> {
            buchung.setGast(gast);
            return buchungRepository.save(buchung);
        }).orElseThrow(() -> new ResourceNotFoundException("GastId " + gastId + " not found"));
    }
    @GetMapping("/gast/{gastId}/buchung")
    public Page<Buchung> getAllBuchungbyGastId(@PathVariable (value = "gastId") Long gastId,
                                               Pageable pageable) {
        return buchungRepository.findByGastId(gastId, pageable);
    }
    @PutMapping("gast/{gastId}/buchung/{buchungId}")
    public Buchung updateBuchung(@PathVariable (value = "gastId") Long gastId,
                                 @PathVariable (value = "buchungId") Long buchungId,
                                 @Valid @RequestBody Buchung buchung1) {
        if(!gastRepository.existsById(gastId)) {
            throw new ResourceNotFoundException("GastId " + gastId + " not found");
        }

        return buchungRepository.findById(buchungId).map(buchung2 -> {
            buchung2.setBuchungsNummer(buchung1.getBuchungsNummer());
            return buchungRepository.save(buchung2);
        }).orElseThrow(() -> new ResourceNotFoundException("BuchungId " + buchungId + "not found"));
    }
    @DeleteMapping("gast/{gastId}/buchung/{buchungId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "gastId") Long gastId,
                                           @PathVariable (value = "buchungId") Long buchungId) {
        return buchungRepository.findByIdAndGastId(buchungId, gastId).map(buchung -> {
            buchungRepository.delete(buchung);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Buchung not found with id " + buchungId + " and GastId " + gastId));
    }


    

}



