package com.hassler.BuchungPOS.servicelayer;

import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.domain.Gast;
import com.hassler.BuchungPOS.repository.BuchungRepository;
import com.hassler.BuchungPOS.repository.GastRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastService {

    @Autowired
    GastRepository gastRepository;

    public Gast createGast(Gast gast)
    {
        return gastRepository.save(gast);
    }
    public List<Gast> retrieveAllGast()
    {
        return (List<Gast>) gastRepository.findAll();

    }
    public Gast updateGast(Long gastId , Gast gast2)
    {
        return gastRepository.findById(gastId).map(gast -> {
            gast.setName(gast2.getName());
            return gastRepository.save(gast);
        }).orElse(null);
    }
    public ResponseEntity<Object> deleteGast(Long gastId)
    {
        return gastRepository.findById(gastId).map(gast -> {
            gastRepository.delete(gast);
            return ResponseEntity.ok().build();
        }).orElse(null);
    }
}
