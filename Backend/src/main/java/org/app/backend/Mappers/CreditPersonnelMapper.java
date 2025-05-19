package org.app.backend.Mappers;

import org.app.backend.DTOs.CreditPersonnelDTO;
import org.app.backend.Entities.CreditPersonnel;
import org.springframework.stereotype.Component;

@Component
public class CreditPersonnelMapper {
    public CreditPersonnelDTO toDTO(CreditPersonnel cp) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        dto.setId(cp.getId());
        dto.setDateDemande(cp.getDateDemande());
        dto.setStatut(cp.getStatut());
        dto.setDateAcception(cp.getDateAcception());
        dto.setMontant(cp.getMontant());
        dto.setDureeRemboursement(cp.getDureeRemboursement());
        dto.setTauxInteret(cp.getTauxInteret());
        dto.setClientId(cp.getClient() != null ? cp.getClient().getId() : null);
        dto.setMotif(cp.getMotif());
        return dto;
    }

    public CreditPersonnel toEntity(CreditPersonnelDTO dto) {
        CreditPersonnel cp = new CreditPersonnel();
        cp.setId(dto.getId());
        cp.setDateDemande(dto.getDateDemande());
        cp.setStatut(dto.getStatut());
        cp.setDateAcception(dto.getDateAcception());
        cp.setMontant(dto.getMontant());
        cp.setDureeRemboursement(dto.getDureeRemboursement());
        cp.setTauxInteret(dto.getTauxInteret());
        cp.setMotif(dto.getMotif());
        return cp;
    }
}

