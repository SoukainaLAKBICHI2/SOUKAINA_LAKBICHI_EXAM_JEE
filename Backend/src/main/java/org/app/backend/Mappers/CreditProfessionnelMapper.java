package org.app.backend.Mappers;

import org.app.backend.DTOs.CreditProfessionnelDTO;
import org.app.backend.Entities.CreditProfessionnel;
import org.springframework.stereotype.Component;

@Component
public class CreditProfessionnelMapper {
    public CreditProfessionnelDTO toDTO(CreditProfessionnel cp) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        dto.setId(cp.getId());
        dto.setDateDemande(cp.getDateDemande());
        dto.setStatut(cp.getStatut());
        dto.setDateAcception(cp.getDateAcception());
        dto.setMontant(cp.getMontant());
        dto.setDureeRemboursement(cp.getDureeRemboursement());
        dto.setTauxInteret(cp.getTauxInteret());
        dto.setClientId(cp.getClient() != null ? cp.getClient().getId() : null);
        dto.setMotif(cp.getMotif());
        dto.setRaisonSociale(cp.getRaisonSociale());
        return dto;
    }

    public CreditProfessionnel toEntity(CreditProfessionnelDTO dto) {
        CreditProfessionnel cp = new CreditProfessionnel();
        cp.setId(dto.getId());
        cp.setDateDemande(dto.getDateDemande());
        cp.setStatut(dto.getStatut());
        cp.setDateAcception(dto.getDateAcception());
        cp.setMontant(dto.getMontant());
        cp.setDureeRemboursement(dto.getDureeRemboursement());
        cp.setTauxInteret(dto.getTauxInteret());
        cp.setMotif(dto.getMotif());
        cp.setRaisonSociale(dto.getRaisonSociale());
        return cp;
    }
}

