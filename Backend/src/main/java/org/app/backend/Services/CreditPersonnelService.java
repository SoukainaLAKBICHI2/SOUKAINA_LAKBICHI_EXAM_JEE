package org.app.backend.Services;

import lombok.RequiredArgsConstructor;
import org.app.backend.Entities.Client;
import org.app.backend.Entities.CreditPersonnel;
import org.app.backend.Repositories.ClientRepository;
import org.app.backend.Repositories.CreditPersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditPersonnelService {
    private final CreditPersonnelRepository personnelRepo;
    private final ClientRepository clientRepository;

    public List<CreditPersonnel> getAll() {
        return personnelRepo.findAll();
    }

    public CreditPersonnel getById(Long id) {
        return personnelRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Crédit personnel non trouvé"));
    }

    public CreditPersonnel save(CreditPersonnel credit, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        credit.setClient(client);
        return personnelRepo.save(credit);
    }

    public void delete(Long id) {
        personnelRepo.deleteById(id);
    }
}

