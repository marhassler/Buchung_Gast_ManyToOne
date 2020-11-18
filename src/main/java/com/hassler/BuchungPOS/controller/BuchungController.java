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
       return buchungService.createBuchung(gastId, buchung);
    }
    @GetMapping("/gast/{gastId}/buchung")
    public Page<Buchung> getAllBuchungbyGastId(@PathVariable (value = "gastId") Long gastId,
                                               Pageable pageable) {
        return buchungService.retrieveBuchung(gastId, pageable);
    }
    @PutMapping("gast/{gastId}/buchung/{buchungId}")
    public Buchung updateBuchung(@PathVariable (value = "gastId") Long gastId,
                                 @PathVariable (value = "buchungId") Long buchungId,
                                 @Valid @RequestBody Buchung buchung1) {
        return buchungService.updateBuchung(gastId,buchungId,buchung1);
    }
    @DeleteMapping("gast/{gastId}/buchung/{buchungId}")
    public ResponseEntity<?> deleteBuchung(@PathVariable (value = "gastId") Long gastId,
                                           @PathVariable (value = "buchungId") Long buchungId) {
        return buchungService.deleteBuchung(gastId,buchungId);
    }


    

}



