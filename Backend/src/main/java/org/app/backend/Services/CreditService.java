package org.app.backend.Services;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Credit;
import org.app.backend.Entities.StatutCredit;
import org.app.backend.Repositories.ClientRepository;
import org.app.backend.Repositories.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit getCreditById(Long id) {
        return creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
    }

    public List<Credit> getCreditsByClientId(Long clientId) {
        return creditRepository.findByClientId(clientId);
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    public Credit updateStatus(Long creditId, StatutCredit statut) {
        Credit credit = getCreditById(creditId);
        credit.setStatut(statut);
        return creditRepository.save(credit);
    }
}
