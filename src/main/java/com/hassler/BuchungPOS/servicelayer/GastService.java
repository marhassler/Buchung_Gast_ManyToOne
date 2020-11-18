package com.hassler.BuchungPOS.servicelayer;

import com.hassler.BuchungPOS.domain.Gast;
import com.hassler.BuchungPOS.repository.GastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastService {

    @Autowired
    GastRepository gastRepository;

    public void createGast(Gast Gast)
    {
        gastRepository.save(Gast);
    }
    public Gast retrieveGast(Long id)
    {
        Optional<Gast> selectedGast = gastRepository.findById(id);
        return selectedGast.orElse(null);

    }
    public void updateGast(Long id , Gast Gast)
    {
        Optional<Gast> selectedGast = gastRepository.findById(id);
        if(selectedGast.isPresent())
        {
            Gast newGast = selectedGast.get();
            newGast.setName(Gast.getName());
            gastRepository.save(newGast);
        }
    }
    public void deleteGast(Long id)
    {
        gastRepository.deleteById(id);
    }
}
