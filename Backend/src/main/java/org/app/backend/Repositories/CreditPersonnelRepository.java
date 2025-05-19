package org.app.backend.Repositories;

import org.app.backend.Entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
    List<CreditPersonnel> findByMotifContainingIgnoreCase(String motif);
}

