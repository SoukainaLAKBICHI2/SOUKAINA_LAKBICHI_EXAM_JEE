package org.app.backend.Services;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Credit;
import org.app.backend.Entities.Remboursement;
import org.app.backend.Repositories.CreditRepository;
import org.app.backend.Repositories.RemboursementRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RemboursementService {
    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    @PreAuthorize("hasAuthority('SCOPE_CLIENT')")
    public List<Remboursement> getRemboursementsByCreditId(Long creditId) {
        return remboursementRepository.findByCreditId(creditId);
    }

    public Remboursement saveRemboursement(Remboursement remboursement, Long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
        remboursement.setCredit(credit);
        return remboursementRepository.save(remboursement);
    }

    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}
