package org.app.backend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.backend.Entities.TypeRemboursement;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypeRemboursement type;
    private Long creditId;
}

