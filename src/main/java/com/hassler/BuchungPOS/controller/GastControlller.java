package com.hassler.BuchungPOS.controller;

import com.hassler.BuchungPOS.domain.Gast;
import com.hassler.BuchungPOS.repository.GastRepository;
import com.hassler.BuchungPOS.servicelayer.BuchungService;
import com.hassler.BuchungPOS.servicelayer.GastService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GastControlller {

    @Autowired
    GastRepository gastRepository;

    private final BuchungService buchungService;

    private final GastService gastService;
    @Autowired
    public GastControlller(BuchungService buchungService, GastService gastService) {
        this.buchungService = buchungService;
        this.gastService = gastService;
    }

    @GetMapping("/gast")
    public List<Gast> getAllGast() {
        return gastService.retrieveAllGast();
    }

    @PostMapping("/gast")
    public Gast createGast(@Valid @RequestBody Gast gast) {
        return gastService.createGast(gast);
    }

    @PutMapping("/gast/{gastId}")
    public Gast updatePost(@PathVariable Long gastId, @Valid @RequestBody Gast gast2) {
        return gastService.updateGast(gastId,gast2);
    }


    @DeleteMapping("/gast/{gastId}")
    public ResponseEntity<?> deletePost(@PathVariable Long gastId) {
       return gastService.deleteGast(gastId);
    }


}
