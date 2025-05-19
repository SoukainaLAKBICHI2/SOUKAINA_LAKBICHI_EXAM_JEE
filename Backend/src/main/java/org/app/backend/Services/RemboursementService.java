package org.app.backend.Services;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Credit;
import org.app.backend.Entities.Remboursement;
import org.app.backend.Repositories.CreditRepository;
import org.app.backend.Repositories.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemboursementService {
    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;

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
