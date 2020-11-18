package com.hassler.BuchungPOS.servicelayer;

import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.repository.BuchungRepository;
import com.hassler.BuchungPOS.repository.GastRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuchungService {

    @Autowired
    BuchungRepository buchungRepository;

    @Autowired
    GastRepository gastRepository;

    public Buchung createBuchung(Long gastId, Buchung buchung)
    {
        return gastRepository.findById(gastId).map(gast -> {
            buchung.setGast(gast);
            return buchungRepository.save(buchung);
        }).orElse(null);
    }
    public Page<Buchung> retrieveBuchung(Long gastId, Pageable pageable)
    {
        return buchungRepository.findByGastId(gastId, pageable);

    }
    public Buchung updateBuchung(Long gastId ,Long buchungId, Buchung buchung1)
    {
        if(!gastRepository.existsById(gastId)) {
            return null;
        }

        return buchungRepository.findById(buchungId).map(buchung2 -> {
            buchung2.setBuchungsNummer(buchung1.getBuchungsNummer());
            return buchungRepository.save(buchung2);
        }).orElse(null);
    }
    public ResponseEntity<?> deleteBuchung(Long gastId ,Long buchungId)
    {
        return buchungRepository.findByIdAndGastId(buchungId,gastId).map(buchung -> {
            buchungRepository.delete(buchung);
            return ResponseEntity.ok().build();
        }).orElse(null);
    }

    public BuchungRepository getBuchungRepository() {
        return buchungRepository;
    }
}
