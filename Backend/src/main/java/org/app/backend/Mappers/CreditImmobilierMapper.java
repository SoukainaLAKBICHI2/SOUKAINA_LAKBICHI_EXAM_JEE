package org.app.backend.Mappers;

import org.app.backend.DTOs.CreditImmobilierDTO;
import org.app.backend.Entities.CreditImmobilier;
import org.app.backend.Entities.TypeBienImmobilier;
import org.springframework.stereotype.Component;

@Component
public class CreditImmobilierMapper {
    public CreditImmobilierDTO toDTO(CreditImmobilier ci) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        dto.setId(ci.getId());
        dto.setDateDemande(ci.getDateDemande());
        dto.setStatut(ci.getStatut());
        dto.setDateAcception(ci.getDateAcception());
        dto.setMontant(ci.getMontant());
        dto.setDureeRemboursement(ci.getDureeRemboursement());
        dto.setTauxInteret(ci.getTauxInteret());
        dto.setClientId(ci.getClient() != null ? ci.getClient().getId() : null);
        dto.setTypeBien(String.valueOf(ci.getTypeBien()));
        return dto;
    }

    public CreditImmobilier toEntity(CreditImmobilierDTO dto) {
        CreditImmobilier ci = new CreditImmobilier();
        ci.setId(dto.getId());
        ci.setDateDemande(dto.getDateDemande());
        ci.setStatut(dto.getStatut());
        ci.setDateAcception(dto.getDateAcception());
        ci.setMontant(dto.getMontant());
        ci.setDureeRemboursement(dto.getDureeRemboursement());
        ci.setTauxInteret(dto.getTauxInteret());
        ci.setTypeBien(TypeBienImmobilier.valueOf(dto.getTypeBien()));
        return ci;
    }
}
