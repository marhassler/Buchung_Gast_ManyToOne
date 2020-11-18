package com.hassler.BuchungPOS.servicelayer;

import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.repository.BuchungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuchungService {

    @Autowired
    BuchungRepository buchungRepository;

    public void createBuchung(Buchung buchung)
    {
        buchungRepository.save(buchung);
    }
    public Buchung retrieveBuchung(Long id)
    {
        Optional<Buchung> selectedBuchung = buchungRepository.findById(id);
        if (selectedBuchung.isPresent())
        {
            return selectedBuchung.get();
        }
        return null;

    }
    public void updateBuchung(Long id , Buchung buchung)
    {
        Optional<Buchung> selectedBuchung = buchungRepository.findById(id);
        if(selectedBuchung.isPresent())
        {
            Buchung newBuchung = selectedBuchung.get();
            newBuchung.setBuchungsNummer(buchung.getBuchungsNummer());
            newBuchung.setGast(buchung.getGast());


            buchungRepository.save(newBuchung);
        }
    }
    public void deleteBuchung(Long id)
    {
        buchungRepository.deleteById(id);
    }
}
