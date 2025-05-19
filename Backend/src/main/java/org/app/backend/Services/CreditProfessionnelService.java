package org.app.backend.Services;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Client;
import org.app.backend.Entities.CreditProfessionnel;
import org.app.backend.Repositories.ClientRepository;
import org.app.backend.Repositories.CreditProfessionnelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditProfessionnelService {
    private final CreditProfessionnelRepository professionnelRepo;
    private final ClientRepository clientRepository;

    public List<CreditProfessionnel> getAll() {
        return professionnelRepo.findAll();
    }

    public CreditProfessionnel getById(Long id) {
        return professionnelRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Crédit professionnel non trouvé"));
    }

    public CreditProfessionnel save(CreditProfessionnel credit, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        credit.setClient(client);
        return professionnelRepo.save(credit);
    }

    public void delete(Long id) {
        professionnelRepo.deleteById(id);
    }
}

