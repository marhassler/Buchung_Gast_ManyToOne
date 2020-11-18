package com.hassler.BuchungPOS.repository;

import com.hassler.BuchungPOS.domain.Gast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastRepository extends CrudRepository<Gast,Long> {
}
