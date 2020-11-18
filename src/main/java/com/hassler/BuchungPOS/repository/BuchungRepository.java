package com.hassler.BuchungPOS.repository;

import com.hassler.BuchungPOS.domain.Buchung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchungRepository extends CrudRepository<Buchung,Long> {
}
