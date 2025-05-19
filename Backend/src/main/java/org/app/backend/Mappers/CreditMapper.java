package org.app.backend.Mappers;

import org.app.backend.DTOs.CreditDTO;
import org.app.backend.Entities.Credit;
import org.springframework.stereotype.Component;

@Component
public class CreditMapper {
    public CreditDTO toDTO(Credit c) {
        if (c == null) return null;
        CreditDTO dto = new CreditDTO();
        dto.setId(c.getId());
        dto.setDateDemande(c.getDateDemande());
        dto.setStatut(c.getStatut());
        dto.setDateAcception(c.getDateAcception());
        dto.setMontant(c.getMontant());
        dto.setDureeRemboursement(c.getDureeRemboursement());
        dto.setTauxInteret(c.getTauxInteret());
        dto.setClientId(c.getClient() != null ? c.getClient().getId() : null);
        return dto;
    }

    public Credit toEntity(CreditDTO dto) {
        // Cette méthode ne peut instancier une sous-classe concrète
        throw new UnsupportedOperationException("Use subclass mappers for entity conversion");
    }
}

