package org.app.backend.Mappers;

import org.app.backend.DTOs.RemboursementDTO;
import org.app.backend.Entities.Remboursement;
import org.springframework.stereotype.Component;

@Component
public class RemboursementMapper {
    public RemboursementDTO toDTO(Remboursement r) {
        if (r == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(r.getId());
        dto.setDate(r.getDate());
        dto.setMontant(r.getMontant());
        dto.setType(r.getType());
        dto.setCreditId(r.getCredit() != null ? r.getCredit().getId() : null);
        return dto;
    }

    public Remboursement toEntity(RemboursementDTO dto) {
        if (dto == null) return null;
        Remboursement r = new Remboursement();
        r.setId(dto.getId());
        r.setDate(dto.getDate());
        r.setMontant(dto.getMontant());
        r.setType(dto.getType());

        return r;
    }
}

