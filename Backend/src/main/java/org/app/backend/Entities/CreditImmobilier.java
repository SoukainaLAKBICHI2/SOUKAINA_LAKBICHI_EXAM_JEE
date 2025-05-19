package org.app.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private TypeBienImmobilier typeBien;
}
