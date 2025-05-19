package org.app.backend.Services;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Client;
import org.app.backend.Entities.CreditImmobilier;
import org.app.backend.Repositories.ClientRepository;
import org.app.backend.Repositories.CreditImmobilierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditImmobilierService {
    private final CreditImmobilierRepository immobilierRepo;
    private final ClientRepository clientRepository;

    public List<CreditImmobilier> getAll() {
        return immobilierRepo.findAll();
    }

    public CreditImmobilier getById(Long id) {
        return immobilierRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Crédit immobilier non trouvé"));
    }

    public CreditImmobilier save(CreditImmobilier credit, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        credit.setClient(client);
        return immobilierRepo.save(credit);
    }

    public void delete(Long id) {
        immobilierRepo.deleteById(id);
    }
}
