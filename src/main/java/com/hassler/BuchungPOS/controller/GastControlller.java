package com.hassler.BuchungPOS.controller;

import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.domain.Gast;
import com.hassler.BuchungPOS.servicelayer.GastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gast")
@RestController
public class GastControlller {

    private final GastService gastService;
    @Autowired
    public GastControlller(GastService gastService) {
        this.gastService = gastService;
    }

    @PostMapping
    public ResponseEntity<String> createBuchung(@RequestBody Gast gast)
    {
        gastService.createGast(gast);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
