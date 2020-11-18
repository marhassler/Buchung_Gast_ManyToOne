package com.hassler.BuchungPOS.repository;

import com.hassler.BuchungPOS.domain.Buchung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuchungRepository extends CrudRepository<Buchung,Long> {
    Page<Buchung> findByGastId(Long postId, Pageable pageable);
    Optional<Buchung> findByIdAndGastId(Long id, Long postId);
}
